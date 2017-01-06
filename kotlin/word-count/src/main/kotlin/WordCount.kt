object WordCount {
    fun phrase(sentence: String): Map<String, Int> {
        val words = sentence
                .toLowerCase()
                .split(" ")
                .map {
                    it.replace(Regex("[:!&@$%^&,.]"), "")
                }
                .filter(String::isNotEmpty)
        return words.map{
            it to count(it, words)
        }.toMap()
    }

    fun count(word: String, words: List<String>): Int {
        val duplicates = words.filter { it == word }
        return duplicates.size
    }
}