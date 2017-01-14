object Hamming {
    fun compute(base: String, compare: String): Int {
        if (base.length != compare.length) throw IllegalArgumentException(
                "Strands not of equal length (strand A is ${base.length} and strand B is ${compare.length})."
        )
        var counter = 0
        base.toList().mapIndexed { i, c ->
            if (c != compare.toList()[i]) {
                counter++
            }
        }
        return counter
    }
}