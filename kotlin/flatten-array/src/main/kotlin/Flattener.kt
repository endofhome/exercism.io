object Flattener {
    fun flatten(list: List<Any?>): List<Any> = list.flatMap {
        when (it) {
            is List<*> -> flatten(it)
            else -> listOf(it)
        }
    }.filterNotNull()
}