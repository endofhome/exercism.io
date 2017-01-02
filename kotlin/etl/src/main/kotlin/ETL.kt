object ETL {
    fun  transform(old: Map<Int, List<String>>): Map<String, Int> {
        val firstEntry = old.entries.first()
        return mapOf(firstEntry.value.get(0).toLowerCase() to firstEntry.key)
    }
}