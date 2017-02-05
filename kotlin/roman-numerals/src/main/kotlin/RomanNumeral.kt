object RomanNumeral {
    private val ONE = "I"
    private val FIVE = "V"

    fun value(input: Int): String {
        return when (input) {
            in 0..3 -> addRomanOnes(input)
            in 4..8 -> fiveBased(input)
            else -> "not yet supported"
        }
    }

    private fun fiveBased(input: Int): String {
        return when {
            input == 4 -> ONE + FIVE
            input >= 5 -> FIVE + addRomanOnes(input.minus(5))
            else -> throw IllegalArgumentException("not '5' based")
        }
    }

    private fun addRomanOnes(input: Int) = 1.rangeTo(input).map { ONE }.joinToString("")
}