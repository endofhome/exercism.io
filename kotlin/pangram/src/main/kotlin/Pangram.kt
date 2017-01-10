object Pangrams {
    fun isPangram(sentence : String): Boolean {
        val charCountMap = CharRange('a', 'z').map {
            it to sentence.contains(it)
        }.toMap()

        return charCountMap.values.all { it }
    }
}