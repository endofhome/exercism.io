object Binary {
    fun toDecimal(input: String): Int {
        if (input.isNotBinaryNumber()) return 0

        var radix = 1
        return input.reversed().map {
            when (it) {
                '1' -> {
                    val currentRadix = radix
                    radix *= 2
                    currentRadix
                }
                else -> {
                    radix *= 2
                    0
                }
            }
        }.sum()
    }
}

private fun String.isNotBinaryNumber(): Boolean = this.any { it != '0' && it != '1' }
