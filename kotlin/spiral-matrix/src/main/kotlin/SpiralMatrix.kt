object SpiralMatrix {
    fun ofSize(int: Int) = when(int) {
        0    -> emptyArray<IntArray>()
        else -> {
            val partitioned = (1..int * int).partition { it <= int }
            val lessThanInt = partitioned.first.toIntArray()
            val greaterThanIntReversed = partitioned.second.reversed().toIntArray()
            listOf(lessThanInt, greaterThanIntReversed)
                    .filter { it.isNotEmpty() }
                    .toTypedArray()
        }
    }
}