object Binary {
    fun toDecimal(input: String): Int {
        return input.fold(0) { value, char ->
            when (char) {
                '0' -> value shl 1
                '1' -> (value shl 1) + 1
                else -> return 0
            }
        }
    }
}