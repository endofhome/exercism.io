object Hamming {
    fun compute(base: String, compare: String): Int {
        require(base.length == compare.length,
                { "Strands not of equal length (strand A has ${base.length} nucleotides and strand B has ${compare.length}) nucleotides." }
        )
        return base.zip(compare).count { it.first != it.second }
    }
}