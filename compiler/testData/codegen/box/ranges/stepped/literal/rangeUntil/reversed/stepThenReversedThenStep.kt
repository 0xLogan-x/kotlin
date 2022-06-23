// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// WITH_STDLIB
// !LANGUAGE: +RangeUntilOperator
@file:OptIn(ExperimentalStdlibApi::class)
import kotlin.test.*

fun box(): String {
    val intList = mutableListOf<Int>()
    for (i in (1..<11 step 2).reversed() step 3) {
        intList += i
    }
    assertEquals(listOf(9, 6, 3), intList)

    val longList = mutableListOf<Long>()
    for (i in (1L..<11L step 2L).reversed() step 3L) {
        longList += i
    }
    assertEquals(listOf(9L, 6L, 3L), longList)

    val charList = mutableListOf<Char>()
    for (i in ('a'..<'k' step 2).reversed() step 3) {
        charList += i
    }
    assertEquals(listOf('i', 'f', 'c'), charList)

    return "OK"
}