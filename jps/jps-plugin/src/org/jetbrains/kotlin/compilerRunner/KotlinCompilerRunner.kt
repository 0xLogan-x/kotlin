/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.compilerRunner

import com.intellij.openapi.util.text.StringUtil
import com.intellij.util.ArrayUtil
import com.intellij.util.Function
import com.intellij.util.containers.ContainerUtil
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.kotlin.cli.common.ExitCode
import org.jetbrains.kotlin.cli.common.arguments.CommonCompilerArguments
import org.jetbrains.kotlin.cli.common.arguments.K2JSCompilerArguments
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.common.messages.MessageCollectorUtil
import org.jetbrains.kotlin.config.CompilerSettings
import org.jetbrains.kotlin.load.kotlin.incremental.components.IncrementalCache
import org.jetbrains.kotlin.modules.TargetId
import org.jetbrains.kotlin.rmi.*
import org.jetbrains.kotlin.rmi.kotlinr.DaemonReportCategory
import org.jetbrains.kotlin.rmi.kotlinr.DaemonReportMessage
import org.jetbrains.kotlin.rmi.kotlinr.DaemonReportingTargets
import org.jetbrains.kotlin.rmi.kotlinr.KotlinCompilerClient
import org.jetbrains.kotlin.utils.*

import java.io.*
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.ArrayList

import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity.ERROR
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity.INFO

public object KotlinCompilerRunner {
    private val K2JVM_COMPILER = "org.jetbrains.kotlin.cli.jvm.K2JVMCompiler"
    private val K2JS_COMPILER = "org.jetbrains.kotlin.cli.js.K2JSCompiler"
    private val INTERNAL_ERROR = ExitCode.INTERNAL_ERROR.toString()

    public fun runK2JvmCompiler(
            commonArguments: CommonCompilerArguments,
            k2jvmArguments: K2JVMCompilerArguments,
            compilerSettings: CompilerSettings,
            messageCollector: MessageCollector,
            environment: CompilerEnvironment,
            incrementalCaches: Map<TargetId, IncrementalCache>?,
            moduleFile: File,
            collector: OutputItemsCollector) {
        val arguments = mergeBeans(commonArguments, k2jvmArguments)
        setupK2JvmArguments(moduleFile, arguments)

        runCompiler(K2JVM_COMPILER, arguments, compilerSettings.additionalArguments, messageCollector, collector, environment,
                    incrementalCaches)
    }

    public fun runK2JsCompiler(
            commonArguments: CommonCompilerArguments,
            k2jsArguments: K2JSCompilerArguments,
            compilerSettings: CompilerSettings,
            messageCollector: MessageCollector,
            environment: CompilerEnvironment,
            incrementalCaches: Map<TargetId, IncrementalCache>?,
            collector: OutputItemsCollector,
            sourceFiles: Collection<File>,
            libraryFiles: List<String>,
            outputFile: File) {
        val arguments = mergeBeans(commonArguments, k2jsArguments)
        setupK2JsArguments(outputFile, sourceFiles, libraryFiles, arguments)

        runCompiler(K2JS_COMPILER, arguments, compilerSettings.additionalArguments, messageCollector, collector, environment,
                    incrementalCaches)
    }

    private fun ProcessCompilerOutput(
            messageCollector: MessageCollector,
            collector: OutputItemsCollector,
            stream: ByteArrayOutputStream,
            exitCode: String) {
        val reader = BufferedReader(StringReader(stream.toString()))
        CompilerOutputParser.parseCompilerMessagesFromReader(messageCollector, reader, collector)

        if (INTERNAL_ERROR == exitCode) {
            reportInternalCompilerError(messageCollector)
        }
    }

    private fun reportInternalCompilerError(messageCollector: MessageCollector) {
        messageCollector.report(ERROR, "Compiler terminated with internal error", CompilerMessageLocation.NO_LOCATION)
    }

    private fun runCompiler(
            compilerClassName: String,
            arguments: CommonCompilerArguments,
            additionalArguments: String,
            messageCollector: MessageCollector,
            collector: OutputItemsCollector,
            environment: CompilerEnvironment,
            incrementalCaches: Map<TargetId, IncrementalCache>?) {
        try {
            messageCollector.report(INFO, "Using kotlin-home = " + environment.kotlinPaths.homePath, CompilerMessageLocation.NO_LOCATION)

            val argumentsList = ArgumentUtils.convertArgumentsToStringList(arguments)
            argumentsList.addAll(StringUtil.split(additionalArguments, " "))

            val argsArray = ArrayUtil.toStringArray(argumentsList)

            if (!tryCompileWithDaemon(messageCollector, collector, environment, incrementalCaches, argsArray)) {
                // otherwise fallback to in-process

                val stream = ByteArrayOutputStream()
                val out = PrintStream(stream)

                val rc = CompilerRunnerUtil.invokeExecMethod(compilerClassName, argsArray, environment, messageCollector, out)

                // exec() returns an ExitCode object, class of which is loaded with a different class loader,
                // so we take it's contents through reflection
                ProcessCompilerOutput(messageCollector, collector, stream, getReturnCodeFromObject(rc))
            }
        }
        catch (e: Throwable) {
            MessageCollectorUtil.reportException(messageCollector, e)
            reportInternalCompilerError(messageCollector)
        }

    }

    private fun tryCompileWithDaemon(
            messageCollector: MessageCollector,
            collector: OutputItemsCollector,
            environment: CompilerEnvironment,
            incrementalCaches: Map<TargetId, IncrementalCache>?,
            argsArray: Array<String>): Boolean {
        if (incrementalCaches != null && isDaemonEnabled()) {
            val libPath = CompilerRunnerUtil.getLibPath(environment.kotlinPaths, messageCollector)
            // TODO: it may be a good idea to cache the compilerId, since making it means calculating digest over jar(s) and if \\
            //    the lifetime of JPS process is small anyway, we can neglect the probability of changed compiler
            val compilerId = CompilerId.makeCompilerId(File(libPath, "kotlin-compiler.jar"))
            val daemonOptions = configureDaemonOptions()
            val daemonJVMOptions = configureDaemonJVMOptions(true)

            val daemonReportMessages = ArrayList<DaemonReportMessage>()

            val daemon = KotlinCompilerClient.connectToCompileService(compilerId, daemonJVMOptions, daemonOptions, DaemonReportingTargets(null, daemonReportMessages), true, true)

            for (msg in daemonReportMessages) {
                if (msg.category === DaemonReportCategory.EXCEPTION && daemon == null) {
                    messageCollector.report(CompilerMessageSeverity.INFO,
                                            "Falling  back to compilation without daemon due to error: " + msg.message,
                                            CompilerMessageLocation.NO_LOCATION)
                }
                else {
                    messageCollector.report(CompilerMessageSeverity.INFO, msg.message, CompilerMessageLocation.NO_LOCATION)
                }
            }

            if (daemon != null) {
                val compilerOut = ByteArrayOutputStream()
                val daemonOut = ByteArrayOutputStream()

                val res = KotlinCompilerClient.incrementalCompile(daemon, argsArray, incrementalCaches, compilerOut, daemonOut)

                ProcessCompilerOutput(messageCollector, collector, compilerOut, res.toString())
                BufferedReader(StringReader(daemonOut.toString())).forEachLine {
                    messageCollector.report(CompilerMessageSeverity.INFO, it, CompilerMessageLocation.NO_LOCATION)
                }
                return true
            }
        }
        return false
    }

    private fun getReturnCodeFromObject(rc: Any?): String {
        if (rc == null) {
            return INTERNAL_ERROR
        }
        else if (ExitCode::class.java.name == rc.javaClass.name) {
            return rc.toString()
        }
        else {
            throw IllegalStateException("Unexpected return: " + rc)
        }
    }

    private fun <T : CommonCompilerArguments> mergeBeans(from: CommonCompilerArguments, to: T): T {
        // TODO: rewrite when updated version of com.intellij.util.xmlb is available on TeamCity
        try {
            val copy = XmlSerializerUtil.createCopy(to)

            val fromFields = collectFieldsToCopy(from.javaClass)
            for (fromField in fromFields) {
                val toField = copy.javaClass.getField(fromField.name)
                toField.set(copy, fromField.get(from))
            }

            return copy
        }
        catch (e: NoSuchFieldException) {
            throw rethrow(e)
        }
        catch (e: IllegalAccessException) {
            throw rethrow(e)
        }

    }

    private fun collectFieldsToCopy(clazz: Class<*>): List<Field> {
        val fromFields = ArrayList<Field>()

        var currentClass: Class<*>? = clazz
        while (currentClass != null) {
            for (field in currentClass.declaredFields) {
                val modifiers = field.modifiers
                if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
                    fromFields.add(field)
                }
            }
            currentClass = currentClass.superclass
        }

        return fromFields
    }

    private fun setupK2JvmArguments(moduleFile: File, settings: K2JVMCompilerArguments) {
        settings.module = moduleFile.absolutePath
        settings.noStdlib = true
        settings.noJdkAnnotations = true
        settings.noJdk = true
    }

    private fun setupK2JsArguments(
            outputFile: File,
            sourceFiles: Collection<File>,
            libraryFiles: List<String>,
            settings: K2JSCompilerArguments) {
        settings.noStdlib = true
        settings.freeArgs = ContainerUtil.map(sourceFiles, object : Function<File, String> {
            override fun `fun`(file: File): String {
                return file.path
            }
        })
        settings.outputFile = outputFile.path
        settings.metaInfo = true
        settings.libraryFiles = ArrayUtil.toStringArray(libraryFiles)
    }
}
