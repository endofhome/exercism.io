object RomanNumeral {
    private val ONE = "I"
    private val FIVE = "V"
    private val TEN = "X"

    fun value(input: Int): String {
        return when (input) {
            in 0..3 -> addRomanOnes(input)
            in 4..8 -> fiveOrTenBased(input, FIVE)
            in 9..13 -> fiveOrTenBased(input, TEN)
            else -> "not yet supported"
        }
    }

    private fun fiveOrTenBased(input: Int, base: String): String {
        return when {
            input == 4 || input == 9 -> ONE + base
            input >= 5 -> base + addRomanOnes(input.minus(5))
            else -> throw IllegalArgumentException("not '5' or '10' based")
        }
    }

    private fun addRomanOnes(input: Int) = 1.rangeTo(input).map { ONE }.joinToString("")
}