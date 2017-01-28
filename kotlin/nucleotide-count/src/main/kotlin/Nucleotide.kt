class DNA(private val dnaString: String) {
    private val validNucleotides = listOf('A', 'C', 'G', 'T')
    val nucleotideCounts = nucleotideCounts()

    fun count(char: Char): Int? {
        require(nucleotideCounts.contains(char))

        return nucleotideCounts[char]
    }

    private fun nucleotideCounts(): Map<Char, Int> {
        require(validNucleotides.containsAll(dnaString.toList()))

        return validNucleotides.map {
            char ->
            char to dnaString.count { it == char }
        }.toMap()
    }
}