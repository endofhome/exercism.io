class Anagram(private val inputWord: String) {
    fun match(possibleMatches: List<String>): List<String> {
        return possibleMatches
                .filterNot {
                    it.toLowerCase() == inputWord.toLowerCase()
                }.filter {
                    it.toLowerCase().toList().sorted() == inputWord.toLowerCase().toList().sorted()
                }.toList()
    }
}