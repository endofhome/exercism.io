object Flattener {
    fun flatten(list: List<Any?>) = list.map {
            when (it) {
                is List<*> -> it
                else -> listOf(it)
            }
        }.reduce { acc, l -> acc + l }
}