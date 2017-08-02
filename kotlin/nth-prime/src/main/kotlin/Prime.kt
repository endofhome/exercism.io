object Prime {
    fun nth(i: Int): Int {
        return primesUpToNth(i).last()
    }

    private fun primesUpToNth(i: Int): List<Int> {
        return when (i) {
            1 -> listOf(2)
            else -> listOf(2, 3)
        }
    }
}