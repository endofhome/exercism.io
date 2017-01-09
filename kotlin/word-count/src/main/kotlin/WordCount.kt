object WordCount {
    fun phrase(sentence: String): Map<String, Int> {
        return sentence.toLowerCase()
                .split(Regex("[^a-zA-Z0-9']+"))
                .filter(String::isNotEmpty)
                .groupBy { it }.mapValues { it.value.size }
    }
}