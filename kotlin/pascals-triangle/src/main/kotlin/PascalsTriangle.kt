object PascalsTriangle {
    fun computeTriangle(i: Int): List<List<Int>> = when (i) {
        0    -> emptyList()
        else -> listOf(listOf(i))
    }
}