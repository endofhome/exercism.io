object RomanNumeral {
    fun value(input: Int): String {
        return when (input) {
            in 0..3 -> 1.rangeTo(input).map { "I" }.joinToString("")
            4 -> "IV"
            else -> "not yet supported"
        }
    }
}