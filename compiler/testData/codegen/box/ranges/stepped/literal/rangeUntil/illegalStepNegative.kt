// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// WITH_STDLIB
// KT-34166: Translation of loop over literal completely removes the validation of step
// DONT_TARGET_EXACT_BACKEND: JS
// !LANGUAGE: +RangeUntilOperator
@file:OptIn(ExperimentalStdlibApi::class)
import kotlin.test.*

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        for (i in 1..<8 step -1) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        for (i in 1L..<8L step -1L) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        for (i in 'a'..<'h' step -1) {
        }
    }

    return "OK"
}