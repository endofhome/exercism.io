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
            val itAsInt = getNumericValue(char)
            val length = inputString.length

            val numeralToConvert = when (i) {
                1 -> itAsInt * conversionFactor(length - 1)
                2 -> itAsInt * conversionFactor(length - 2)
                3 -> itAsInt * conversionFactor(length - 3)
                else -> itAsInt * conversionFactor(length)
            }

            arabicToRoman[numeralToConvert] ?: (getRoman(numeralToConvert))
        }.joinToString("")
    }

    private fun conversionFactor(input: Int): Int {
        return when (input) {
            2 -> 10
            3 -> 100
            4 -> 1000
            else -> 1
        }
    }

    private fun getRoman(input: Int): String {
        val firstDigit = getNumericValue(input.toString().toList().first())
        return when (firstDigit) {
            in 0..3 -> addRomanOnes(firstDigit, conversionFactor(input.toString().length))
            in 4..8 -> fiveOrTenBasedRoman(firstDigit, 5 * conversionFactor(input.toString().length))
            9 -> fiveOrTenBasedRoman(firstDigit, 10 * conversionFactor(input.toString().length))
            else -> ""
        }
    }

    private fun fiveOrTenBasedRoman(firstDigit: Int, arabicBase: Int): String {
        val base = arabicToRoman[arabicBase]
        val prefix = arabicToRoman[arabicBase / fiveOrTen(arabicBase)]
        return when {
            firstDigit == 4 || firstDigit == 9 -> prefix + base
            firstDigit >= 5 -> base + addRomanOnes(firstDigit.minus(5), conversionFactor(arabicBase.toString().length))
            else -> throw IllegalArgumentException("not '5' or '10' based")
        }
    }

    private fun fiveOrTen(arabicBase: Int): Int {
        val fiveOrTen = getNumericValue(arabicBase.toString().first())
        if (fiveOrTen == 1) return 10
        return fiveOrTen
    }

    private fun addRomanOnes(numberOfOnes: Int, conversionFactor: Int) = 1.rangeTo(numberOfOnes).map { arabicToRoman[conversionFactor] }.joinToString("")
}