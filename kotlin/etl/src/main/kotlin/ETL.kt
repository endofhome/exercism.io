object ETL {
    fun  transform(old: Map<Int, List<String>>): Map<String, Int> {
        val firstEntry = old.entries.first()
        return firstEntry.value.associateBy({it.toLowerCase()}, {firstEntry.key})
    }
}