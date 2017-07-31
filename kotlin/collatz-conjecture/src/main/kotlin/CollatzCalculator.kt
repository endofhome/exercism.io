object CollatzCalculator {

    fun  computeStepCount(n: Int, counter: Int = 0): Int {
        return when (n == 1) {
            true -> counter
            false -> {
                val updatedN = n / 2
                val updatedCounter = counter + 1
                computeStepCount(updatedN, updatedCounter)
            }
        }
    }
}