class Anagram(private val inputWord: String) {
    fun match(possibleMatches: List<String>): List<String> {
        return possibleMatches.filter {
            it.length == inputWord.length
        }.toList()
    }
}