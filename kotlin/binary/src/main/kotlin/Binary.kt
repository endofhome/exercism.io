object Binary {
    fun toDecimal(input: String): Int {
        val radix = 1
        return input.reversed().map {
            if (it == '1') {
                radix
            } else 0
        }.sum()
    }
}