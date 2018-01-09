object Flattener {
    fun flatten(list: List<Any?>): List<Any> = list.map {
            when (it) {
                is List<*> -> flatten(it)
                else -> listOf(it)
            }
        }.map {
            it.filterNotNull()
        }.reduce { acc, l -> acc + l }
}