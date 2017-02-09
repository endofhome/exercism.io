import java.lang.Character.getNumericValue

object RomanNumeral {
    private val arabicToRoman = mapOf(
            1 to "I",
            5 to "V",
            10 to "X",
            50 to "L",
            100 to "C",
            500 to "D",
            1000 to "M"
    )

    fun value(input: Int): String {
        require(input in 0..3000)

        val inputString = input.toString()

        return inputString.mapIndexed { i, char ->
            val arabicNumeral = numeralToConvert(char, i, inputString)
            arabicToRoman[arabicNumeral] ?: (composeRoman(arabicNumeral))
        }.joinToString("")
    }

    private fun numeralToConvert(char: Char, index: Int, inputString: String): Int {
        val charAsInt = getNumericValue(char)
        val length = inputString.length

        return when (index) {
            0 -> charAsInt * conversionFactor(length)
            1 -> charAsInt * conversionFactor(length - 1)
            2 -> charAsInt * conversionFactor(length - 2)
            3 -> charAsInt * conversionFactor(length - 3)
            else -> throw IllegalArgumentException("number must be below 3000.")
        }
    }

    private fun composeRoman(input: Int): String {
        val firstDigit = getNumericValue(input.toString().toList().first())
        return when (firstDigit) {
            in 0..3 -> addPowersOfTenToRoman(firstDigit, conversionFactor(input.toString().length))
            in 4..8 -> addFiveOrTenBasedRoman(firstDigit, 5 * conversionFactor(input.toString().length))
            9 -> addFiveOrTenBasedRoman(firstDigit, 10 * conversionFactor(input.toString().length))
            else -> throw IllegalArgumentException("input must be between 0 and 9")
        }
    }

    private fun addPowersOfTenToRoman(numberOfOnes: Int, conversionFactor: Int) = 1.rangeTo(numberOfOnes).map { arabicToRoman[conversionFactor] }.joinToString("")

    private fun addFiveOrTenBasedRoman(firstDigit: Int, arabicBase: Int): String {
        val base = arabicToRoman[arabicBase]
        val prefix = arabicToRoman[arabicBase / fiveOrTen(arabicBase)]
        return when {
            firstDigit == 4 || firstDigit == 9 -> prefix + base
            firstDigit >= 5 -> base + addPowersOfTenToRoman(firstDigit.minus(5), conversionFactor(arabicBase.toString().length))
            else -> throw IllegalArgumentException("not a '5' or '10' based roman numeral")
        }
    }

    private fun conversionFactor(stringLength: Int): Int {
        return when (stringLength) {
            1 -> 1
            2 -> 10
            3 -> 100
            4 -> 1000
            else -> throw NoWhenBranchMatchedException("string length must be between § and 4")
        }
    }

    private fun fiveOrTen(arabicBase: Int): Int {
        val fiveOrTen = getNumericValue(arabicBase.toString().first())
        if (fiveOrTen == 1) return 10
        else return 5
    }
}