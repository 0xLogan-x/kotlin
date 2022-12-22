/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.light.classes.symbol.decompiled;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/asJava/lightClasses/lightClasses")
@TestDataPath("$PROJECT_ROOT")
public class SymbolLightClassesForLibraryTestGenerated extends AbstractSymbolLightClassesForLibraryTest {
    @Test
    public void testAllFilesPresentInLightClasses() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses"), Pattern.compile("^([^.]+)\\.kt$"), null, true, "compilationErrors");
    }

    @Test
    @TestMetadata("AnnotatedParameterInEnumConstructor.kt")
    public void testAnnotatedParameterInEnumConstructor() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotatedParameterInEnumConstructor.kt");
    }

    @Test
    @TestMetadata("AnnotatedParameterInInnerClassConstructor.kt")
    public void testAnnotatedParameterInInnerClassConstructor() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotatedParameterInInnerClassConstructor.kt");
    }

    @Test
    @TestMetadata("AnnotatedPropertyWithSites.kt")
    public void testAnnotatedPropertyWithSites() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotatedPropertyWithSites.kt");
    }

    @Test
    @TestMetadata("AnnotationClass.kt")
    public void testAnnotationClass() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotationClass.kt");
    }

    @Test
    @TestMetadata("AnnotationJavaRepeatable.kt")
    public void testAnnotationJavaRepeatable() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotationJavaRepeatable.kt");
    }

    @Test
    @TestMetadata("AnnotationJvmRepeatable.kt")
    public void testAnnotationJvmRepeatable() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotationJvmRepeatable.kt");
    }

    @Test
    @TestMetadata("AnnotationKotlinAndJavaRepeatable.kt")
    public void testAnnotationKotlinAndJavaRepeatable() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotationKotlinAndJavaRepeatable.kt");
    }

    @Test
    @TestMetadata("AnnotationKotlinAndJvmRepeatable.kt")
    public void testAnnotationKotlinAndJvmRepeatable() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotationKotlinAndJvmRepeatable.kt");
    }

    @Test
    @TestMetadata("AnnotationRepeatable.kt")
    public void testAnnotationRepeatable() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/AnnotationRepeatable.kt");
    }

    @Test
    @TestMetadata("Constructors.kt")
    public void testConstructors() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/Constructors.kt");
    }

    @Test
    @TestMetadata("DataClassWithCustomImplementedMembers.kt")
    public void testDataClassWithCustomImplementedMembers() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/DataClassWithCustomImplementedMembers.kt");
    }

    @Test
    @TestMetadata("DelegatedNested.kt")
    public void testDelegatedNested() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/DelegatedNested.kt");
    }

    @Test
    @TestMetadata("Delegation.kt")
    public void testDelegation() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/Delegation.kt");
    }

    @Test
    @TestMetadata("DeprecatedEnumEntry.kt")
    public void testDeprecatedEnumEntry() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/DeprecatedEnumEntry.kt");
    }

    @Test
    @TestMetadata("DeprecatedNotHiddenInClass.kt")
    public void testDeprecatedNotHiddenInClass() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/DeprecatedNotHiddenInClass.kt");
    }

    @Test
    @TestMetadata("DollarsInName.kt")
    public void testDollarsInName() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/DollarsInName.kt");
    }

    @Test
    @TestMetadata("DollarsInNameNoPackage.kt")
    public void testDollarsInNameNoPackage() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/DollarsInNameNoPackage.kt");
    }

    @Test
    @TestMetadata("EnumClass.kt")
    public void testEnumClass() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/EnumClass.kt");
    }

    @Test
    @TestMetadata("EnumClassWithEnumEntries.kt")
    public void testEnumClassWithEnumEntries() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/EnumClassWithEnumEntries.kt");
    }

    @Test
    @TestMetadata("EnumEntry.kt")
    public void testEnumEntry() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/EnumEntry.kt");
    }

    @Test
    @TestMetadata("ExtendingInterfaceWithDefaultImpls.kt")
    public void testExtendingInterfaceWithDefaultImpls() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/ExtendingInterfaceWithDefaultImpls.kt");
    }

    @Test
    @TestMetadata("HiddenDeprecated.kt")
    public void testHiddenDeprecated() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/HiddenDeprecated.kt");
    }

    @Test
    @TestMetadata("HiddenDeprecatedInClass.kt")
    public void testHiddenDeprecatedInClass() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/HiddenDeprecatedInClass.kt");
    }

    @Test
    @TestMetadata("InheritingInterfaceDefaultImpls.kt")
    public void testInheritingInterfaceDefaultImpls() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/InheritingInterfaceDefaultImpls.kt");
    }

    @Test
    @TestMetadata("InlineReified.kt")
    public void testInlineReified() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/InlineReified.kt");
    }

    @Test
    @TestMetadata("JavaBetween.kt")
    public void testJavaBetween() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/JavaBetween.kt");
    }

    @Test
    @TestMetadata("JvmNameOnMember.kt")
    public void testJvmNameOnMember() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/JvmNameOnMember.kt");
    }

    @Test
    @TestMetadata("JvmStatic.kt")
    public void testJvmStatic() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/JvmStatic.kt");
    }

    @Test
    @TestMetadata("LocalFunctions.kt")
    public void testLocalFunctions() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/LocalFunctions.kt");
    }

    @Test
    @TestMetadata("NestedObjects.kt")
    public void testNestedObjects() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/NestedObjects.kt");
    }

    @Test
    @TestMetadata("NonDataClassWithComponentFunctions.kt")
    public void testNonDataClassWithComponentFunctions() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/NonDataClassWithComponentFunctions.kt");
    }

    @Test
    @TestMetadata("OnlySecondaryConstructors.kt")
    public void testOnlySecondaryConstructors() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/OnlySecondaryConstructors.kt");
    }

    @Test
    @TestMetadata("PublishedApi.kt")
    public void testPublishedApi() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/PublishedApi.kt");
    }

    @Test
    @TestMetadata("SpecialAnnotationsOnAnnotationClass.kt")
    public void testSpecialAnnotationsOnAnnotationClass() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/SpecialAnnotationsOnAnnotationClass.kt");
    }

    @Test
    @TestMetadata("StubOrderForOverloads.kt")
    public void testStubOrderForOverloads() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/StubOrderForOverloads.kt");
    }

    @Test
    @TestMetadata("TypePararametersInClass.kt")
    public void testTypePararametersInClass() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/TypePararametersInClass.kt");
    }

    @Test
    @TestMetadata("VarArgs.kt")
    public void testVarArgs() throws Exception {
        runTest("compiler/testData/asJava/lightClasses/lightClasses/VarArgs.kt");
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/delegation")
    @TestDataPath("$PROJECT_ROOT")
    public class Delegation {
        @Test
        public void testAllFilesPresentInDelegation() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/delegation"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("Function.kt")
        public void testFunction() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/delegation/Function.kt");
        }

        @Test
        @TestMetadata("Property.kt")
        public void testProperty() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/delegation/Property.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/facades")
    @TestDataPath("$PROJECT_ROOT")
    public class Facades {
        @Test
        public void testAllFilesPresentInFacades() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/facades"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("AllPrivate.kt")
        public void testAllPrivate() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/facades/AllPrivate.kt");
        }

        @Test
        @TestMetadata("MultiFile.kt")
        public void testMultiFile() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/facades/MultiFile.kt");
        }

        @Test
        @TestMetadata("SingleFile.kt")
        public void testSingleFile() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/facades/SingleFile.kt");
        }

        @Test
        @TestMetadata("SingleJvmClassName.kt")
        public void testSingleJvmClassName() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/facades/SingleJvmClassName.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/ideRegression")
    @TestDataPath("$PROJECT_ROOT")
    public class IdeRegression {
        @Test
        public void testAllFilesPresentInIdeRegression() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/ideRegression"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("AllOpenAnnotatedClasses.kt")
        public void testAllOpenAnnotatedClasses() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/AllOpenAnnotatedClasses.kt");
        }

        @Test
        @TestMetadata("ImplementingCharSequenceAndNumber.kt")
        public void testImplementingCharSequenceAndNumber() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/ImplementingCharSequenceAndNumber.kt");
        }

        @Test
        @TestMetadata("ImplementingMap.kt")
        public void testImplementingMap() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/ImplementingMap.kt");
        }

        @Test
        @TestMetadata("ImplementingMutableSet.kt")
        public void testImplementingMutableSet() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/ImplementingMutableSet.kt");
        }

        @Test
        @TestMetadata("InheritingInterfaceDefaultImpls.kt")
        public void testInheritingInterfaceDefaultImpls() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/InheritingInterfaceDefaultImpls.kt");
        }

        @Test
        @TestMetadata("OverridingFinalInternal.kt")
        public void testOverridingFinalInternal() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/OverridingFinalInternal.kt");
        }

        @Test
        @TestMetadata("OverridingInternal.kt")
        public void testOverridingInternal() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/OverridingInternal.kt");
        }

        @Test
        @TestMetadata("OverridingProtected.kt")
        public void testOverridingProtected() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/ideRegression/OverridingProtected.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations")
    @TestDataPath("$PROJECT_ROOT")
    public class NullabilityAnnotations {
        @Test
        public void testAllFilesPresentInNullabilityAnnotations() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("Class.kt")
        public void testClass() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/Class.kt");
        }

        @Test
        @TestMetadata("ClassObjectField.kt")
        public void testClassObjectField() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/ClassObjectField.kt");
        }

        @Test
        @TestMetadata("ClassWithConstructor.kt")
        public void testClassWithConstructor() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/ClassWithConstructor.kt");
        }

        @Test
        @TestMetadata("ClassWithConstructorAndProperties.kt")
        public void testClassWithConstructorAndProperties() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/ClassWithConstructorAndProperties.kt");
        }

        @Test
        @TestMetadata("FileFacade.kt")
        public void testFileFacade() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/FileFacade.kt");
        }

        @Test
        @TestMetadata("Generic.kt")
        public void testGeneric() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/Generic.kt");
        }

        @Test
        @TestMetadata("IntOverridesAny.kt")
        public void testIntOverridesAny() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/IntOverridesAny.kt");
        }

        @Test
        @TestMetadata("JvmOverloads.kt")
        public void testJvmOverloads() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/JvmOverloads.kt");
        }

        @Test
        @TestMetadata("NullableUnitReturn.kt")
        public void testNullableUnitReturn() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/NullableUnitReturn.kt");
        }

        @Test
        @TestMetadata("OverrideAnyWithUnit.kt")
        public void testOverrideAnyWithUnit() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/OverrideAnyWithUnit.kt");
        }

        @Test
        @TestMetadata("PlatformTypes.kt")
        public void testPlatformTypes() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/PlatformTypes.kt");
        }

        @Test
        @TestMetadata("Primitives.kt")
        public void testPrimitives() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/Primitives.kt");
        }

        @Test
        @TestMetadata("PrivateInClass.kt")
        public void testPrivateInClass() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/PrivateInClass.kt");
        }

        @Test
        @TestMetadata("Synthetic.kt")
        public void testSynthetic() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/Synthetic.kt");
        }

        @Test
        @TestMetadata("Trait.kt")
        public void testTrait() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/Trait.kt");
        }

        @Test
        @TestMetadata("UnitAsGenericArgument.kt")
        public void testUnitAsGenericArgument() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/UnitAsGenericArgument.kt");
        }

        @Test
        @TestMetadata("UnitParameter.kt")
        public void testUnitParameter() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/UnitParameter.kt");
        }

        @Test
        @TestMetadata("VoidReturn.kt")
        public void testVoidReturn() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/nullabilityAnnotations/VoidReturn.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/object")
    @TestDataPath("$PROJECT_ROOT")
    public class Object {
        @Test
        public void testAllFilesPresentInObject() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/object"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("SimpleObject.kt")
        public void testSimpleObject() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/object/SimpleObject.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/publicField")
    @TestDataPath("$PROJECT_ROOT")
    public class PublicField {
        @Test
        public void testAllFilesPresentInPublicField() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/publicField"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("CompanionObject.kt")
        public void testCompanionObject() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/publicField/CompanionObject.kt");
        }

        @Test
        @TestMetadata("Simple.kt")
        public void testSimple() throws Exception {
            runTest("compiler/testData/asJava/lightClasses/lightClasses/publicField/Simple.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/asJava/lightClasses/lightClasses/script")
    @TestDataPath("$PROJECT_ROOT")
    public class Script {
        @Test
        public void testAllFilesPresentInScript() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/asJava/lightClasses/lightClasses/script"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }
    }
}
