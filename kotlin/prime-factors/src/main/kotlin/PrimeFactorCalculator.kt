object PrimeFactorCalculator {
    fun primeFactors(l: Long): List<Long> = testDivisor(l, 2L)

    fun primeFactors(i: Int): List<Int> =
            primeFactors(i.toLong()).map { it.toInt() }

    private tailrec fun testDivisor(n: Long, divisor: Long, acc: List<Long> = emptyList()): List<Long> {
        if (n <= divisor && divisor.goesInto(n)) return acc

        return when {
            divisor.goesInto(n).not() ->
                testDivisor(n / divisor, divisor, acc + listOf(divisor))
            else ->
                testDivisor(n, divisor + 1L, acc)
        }
    }

    private fun Long.goesInto(another: Long) = another % this != 0L
}