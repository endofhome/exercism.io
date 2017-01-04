object ETL {
    fun  transform(old: Map<Int, List<String>>): Map<String, Int> {
        return old.entries.flatMap {
            entry ->
            entry.value.map {
                word ->
                Pair(word.toLowerCase(), entry.key)
            }
        }.toMap()
    }
}