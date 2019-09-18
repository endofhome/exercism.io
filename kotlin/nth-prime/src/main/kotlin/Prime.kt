object Prime {
    fun nth(i: Int): Int {
        require(i > 0)
        return generateSequence(2) { it + 1 }
                .filter { it.isPrime() }
                .take(i)
                .last()
    }

    private fun Int.isPrime() =
        (1..this).filter {
            this % it == 0
        } == listOf(1, this)
}