object PrimeFactorCalculator {
    fun <T>primeFactors(n: T): List<T> = when (n) {
        1    -> emptyList()
        else -> listOf(n)
    }
}