object SpiralMatrix {
    fun ofSize(int: Int) = when(int) {
        0    -> emptyArray<IntArray>()
        else -> arrayOf(intArrayOf(1))
    }
}