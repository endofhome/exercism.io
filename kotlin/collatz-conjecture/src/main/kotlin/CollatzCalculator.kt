object CollatzCalculator {

    fun computeStepCount(n: Int, counter: Int = 0): Int {
        require(n > 0, { "Only natural numbers are allowed" })
        return when (n == 1) {
            true -> counter
            false -> computeStepCount(collatzTransform(n), counter + 1)
        }
    }

    private fun collatzTransform(n: Int): Int = when (n.isEven()) {
        true -> { n / 2 }
        false -> { n * 3 + 1 }
    }
}

private fun Int.isEven(): Boolean {
    return (this % 2 == 0)
}
