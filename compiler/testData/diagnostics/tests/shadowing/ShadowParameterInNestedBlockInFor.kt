fun f(i: Int) {
    for (j in 1..100) {
        {
            var <!NAME_SHADOWING!>i<!> = 12
        }
    }
}
