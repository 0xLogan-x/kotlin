fun f(p: Int): Int {
    val <!NAME_SHADOWING!>p<!> = 2
    return p
}
