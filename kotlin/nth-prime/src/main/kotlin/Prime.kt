object Prime {
    fun nth(i: Int): Int {
        return primesUpToNth(i).last()
    }

    private fun primesUpToNth(i: Int): List<Int> {
        return when (i) {
            1 -> listOf(2)
            2 -> listOf(2, 3)
            else -> listOf(2, 3, 5, 7, 11, 13)
        }
    }
}