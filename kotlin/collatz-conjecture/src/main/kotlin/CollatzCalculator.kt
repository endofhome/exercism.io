object CollatzCalculator {

    fun  computeStepCount(n: Int, counter: Int = 0): Int {
        return when (n == 1) {
            true -> counter
            false -> {
                val updatedN = collatzTransform(n)
                val updatedCounter = counter + 1
                computeStepCount(updatedN, updatedCounter)
            }
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
