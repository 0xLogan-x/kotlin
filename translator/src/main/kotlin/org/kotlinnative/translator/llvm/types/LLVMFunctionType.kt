package org.kotlinnative.translator.llvm.types

import org.jetbrains.kotlin.types.KotlinType
import org.kotlinnative.translator.llvm.LLVMInstanceOfStandardType
import org.kotlinnative.translator.llvm.LLVMVariable

class LLVMFunctionType(type: KotlinType) : LLVMType() {

    override val defaultValue = ""
    override val align: Int = 4
    override var size: Int = 4

    val arguments: List<LLVMVariable>
    val returnType: LLVMVariable

    init {
        val types = type.arguments.map { LLVMInstanceOfStandardType("", it.type) }.toList()
        returnType = types.last()
        arguments = types.dropLast(1)
    }

    override fun mangle() =
            "F.${arguments.joinToString(separator = "_", transform = { it.type.mangle() })}.EF"

    fun mangleArgs(): String =
            if (arguments.size > 0) "_${arguments.joinToString(separator = "_", transform = { it.type.mangle() })}" else ""

    override fun toString(): String =
            "${returnType.type} (${arguments.map { it.getType() }.joinToString()})"

}
