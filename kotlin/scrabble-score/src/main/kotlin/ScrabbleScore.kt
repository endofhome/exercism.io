object Scrabble {
    val scores = mapOf(
            1 to listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
            2 to listOf('D', 'G'),
            3 to listOf('B', 'C', 'M', 'P'),
            4 to listOf('F', 'H', 'V', 'W', 'Y'),
            5 to listOf('K'),
            8 to listOf('J', 'X'),
            10 to listOf('Q', 'Z')
    )

    fun scoreWord(word: String): Int {
        return word.map {
            char ->
            scores.map {
                when {
                    it.value.contains(char.toUpperCase()) -> it.key
                    else -> 0
                }
            }.sum()
        }.sum()
    }
}