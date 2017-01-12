object Hamming {
    fun compute(base: String, compare: String): Int {
        var counter = 0
        base.toList().mapIndexed { i, c ->
            if (c != compare.toList()[i]) {
                counter++
            }
        }
        return counter
    }
}