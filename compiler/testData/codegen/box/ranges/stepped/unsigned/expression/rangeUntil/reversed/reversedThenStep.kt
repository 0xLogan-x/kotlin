// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// WITH_STDLIB
// !LANGUAGE: +RangeUntilOperator
@file:OptIn(ExperimentalStdlibApi::class)
import kotlin.test.*

fun box(): String {
    val uintList = mutableListOf<UInt>()
    val uintProgression = 1u..<9u
    for (i in uintProgression.reversed() step 2) {
        uintList += i
    }
    assertEquals(listOf(8u, 6u, 4u, 2u), uintList)

    val ulongList = mutableListOf<ULong>()
    val ulongProgression = 1uL..<9uL
    for (i in ulongProgression.reversed() step 2L) {
        ulongList += i
    }
    assertEquals(listOf(8uL, 6uL, 4uL, 2uL), ulongList)

    return "OK"
}