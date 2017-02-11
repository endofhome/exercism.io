object Binary {
    fun toDecimal(input: String): Int {
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