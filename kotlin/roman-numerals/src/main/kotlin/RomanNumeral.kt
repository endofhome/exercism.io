object RomanNumeral {
    private val arabicToRoman = mapOf(
        1 to "I",
        5 to "V",
        10 to "X"
    )

    fun value(input: Int): String {
        return when (input) {
            in 0..3 -> addRomanOnes(input)
            in 4..8 -> fiveOrTenBased(input, arabicToRoman[5])
            in 9..13 -> fiveOrTenBased(input, arabicToRoman[10])
            else -> "not yet supported"
        }
    }

    private fun fiveOrTenBased(input: Int, base: String?): String {
        return when {
            input == 4 || input == 9 -> arabicToRoman[1] + base
            input >= 5 -> base + addRomanOnes(input.minus(5))
            else -> throw IllegalArgumentException("not '5' or '10' based")
        }
    }

    private fun addRomanOnes(input: Int) = 1.rangeTo(input).map { arabicToRoman[1] }.joinToString("")
}