object Prime {
    fun nth(i: Int): Int {
        require(i > 0)
        var counter = 2
        return generateSequence { (counter++) }
                .filter { it.isPrime() }
                .take(i)
                .last()
    }

    private fun Int.isPrime() =
        (1..this).filter {
            this % it == 0
        } == listOf(1, this)
}