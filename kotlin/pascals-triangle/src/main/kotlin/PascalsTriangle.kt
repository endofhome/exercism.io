object PascalsTriangle {
    fun computeTriangle(i: Int): List<List<Int>> = when (i) {
        0    -> emptyList()
        else -> {
                (0 until i).map {
                    (0..it).map { 1 }
                }
        }
    }
}