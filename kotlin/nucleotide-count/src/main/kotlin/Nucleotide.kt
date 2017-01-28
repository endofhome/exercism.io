class DNA(private val dnaString: String) {
    val validNucleotides = listOf('A', 'C', 'G', 'T')
    val nucleotideCounts = nucleotideCounts()

    private fun nucleotideCounts(): Map<Char, Int> {
        return validNucleotides.map {
            char ->
            char to dnaString.count { it == char }
        }.toMap()
    }

    fun count(char: Char): Int {
        return nucleotideCounts.getOrElse(char, { 0 })
    }
}