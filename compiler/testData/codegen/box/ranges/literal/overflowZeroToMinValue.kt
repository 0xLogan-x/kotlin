// Auto-generated by org.jetbrains.kotlin.generators.tests.GenerateRangesCodegenTestData. DO NOT EDIT!
// !LANGUAGE: +RangeUntilOperator
// WITH_STDLIB


val MinI = Int.MIN_VALUE
val MinB = Byte.MIN_VALUE
val MinS = Short.MIN_VALUE
val MinL = Long.MIN_VALUE

@OptIn(ExperimentalStdlibApi::class)
fun box(): String {
    val list1 = ArrayList<Int>()
    for (i in 0.toByte()..MinB step 3) {
        list1.add(i)
        if (list1.size > 23) break
    }
    if (list1 != listOf<Int>()) {
        return "Wrong elements for 0.toByte()..MinB step 3: $list1"
    }

    val list2 = ArrayList<Int>()
    for (i in 0.toShort()..MinS step 3) {
        list2.add(i)
        if (list2.size > 23) break
    }
    if (list2 != listOf<Int>()) {
        return "Wrong elements for 0.toShort()..MinS step 3: $list2"
    }

    val list3 = ArrayList<Int>()
    for (i in 0..MinI step 3) {
        list3.add(i)
        if (list3.size > 23) break
    }
    if (list3 != listOf<Int>()) {
        return "Wrong elements for 0..MinI step 3: $list3"
    }

    val list4 = ArrayList<Long>()
    for (i in 0L..MinL step 3) {
        list4.add(i)
        if (list4.size > 23) break
    }
    if (list4 != listOf<Long>()) {
        return "Wrong elements for 0L..MinL step 3: $list4"
    }

    val list5 = ArrayList<Int>()
    for (i in 0.toByte() until MinB step 3) {
        list5.add(i)
        if (list5.size > 23) break
    }
    if (list5 != listOf<Int>()) {
        return "Wrong elements for 0.toByte() until MinB step 3: $list5"
    }

    val list6 = ArrayList<Int>()
    for (i in 0.toShort() until MinS step 3) {
        list6.add(i)
        if (list6.size > 23) break
    }
    if (list6 != listOf<Int>()) {
        return "Wrong elements for 0.toShort() until MinS step 3: $list6"
    }

    val list7 = ArrayList<Int>()
    for (i in 0 until MinI step 3) {
        list7.add(i)
        if (list7.size > 23) break
    }
    if (list7 != listOf<Int>()) {
        return "Wrong elements for 0 until MinI step 3: $list7"
    }

    val list8 = ArrayList<Long>()
    for (i in 0L until MinL step 3) {
        list8.add(i)
        if (list8.size > 23) break
    }
    if (list8 != listOf<Long>()) {
        return "Wrong elements for 0L until MinL step 3: $list8"
    }

    val list9 = ArrayList<Int>()
    for (i in 0.toByte()..<MinB step 3) {
        list9.add(i)
        if (list9.size > 23) break
    }
    if (list9 != listOf<Int>()) {
        return "Wrong elements for 0.toByte()..<MinB step 3: $list9"
    }

    val list10 = ArrayList<Int>()
    for (i in 0.toShort()..<MinS step 3) {
        list10.add(i)
        if (list10.size > 23) break
    }
    if (list10 != listOf<Int>()) {
        return "Wrong elements for 0.toShort()..<MinS step 3: $list10"
    }

    val list11 = ArrayList<Int>()
    for (i in 0..<MinI step 3) {
        list11.add(i)
        if (list11.size > 23) break
    }
    if (list11 != listOf<Int>()) {
        return "Wrong elements for 0..<MinI step 3: $list11"
    }

    val list12 = ArrayList<Long>()
    for (i in 0L..<MinL step 3) {
        list12.add(i)
        if (list12.size > 23) break
    }
    if (list12 != listOf<Long>()) {
        return "Wrong elements for 0L..<MinL step 3: $list12"
    }

    return "OK"
}
