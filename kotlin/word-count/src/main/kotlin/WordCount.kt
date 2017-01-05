object WordCount {
    fun phrase(sentence: String): Map<String, Int> {
        val words = sentence.split(" ")
        return words.map{
            it to 1
        }.toMap()
    }
}