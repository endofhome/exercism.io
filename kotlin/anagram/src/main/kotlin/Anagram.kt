class Anagram(private val inputWord: String) {
    fun match(possibleMatches: List<String>): List<String> {
        return possibleMatches.filter {
            it.toList().sorted() == inputWord.toList().sorted()
        }.toList()
    }
}