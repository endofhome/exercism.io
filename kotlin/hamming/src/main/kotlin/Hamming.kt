object Hamming {
    fun compute(base: String, compare: String): Int {
        require(base.length == compare.length,
                { "Strands not of equal length (strand A has ${base.length} nucleotides and strand B has ${compare.length}) nucleotides." }
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