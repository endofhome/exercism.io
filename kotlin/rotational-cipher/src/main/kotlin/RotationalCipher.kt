import Case.UpperCase
import Case.LowerCase

class RotationalCipher(private val key: Int) {
    private val cases = listOf(UpperCase, LowerCase)

    fun encode(input: String) =
        input.toCharArray().map { char ->
            when {
                char.isLetter() -> char.rotateBy(key)
                else            -> char
            }
        }.joinToString("")

    private fun Char.rotateBy(key: Int): Char {
        val charAsInt = this.toInt()
        val rotatedChar = charAsInt + key

        val rotatedCharAsInt = cases.find { case ->
            charAsInt in case.charRange && rotatedChar > case.lastChar
        }?.adjustInRange(rotatedChar) ?: rotatedChar

        return rotatedCharAsInt.toChar()
    }
}

interface RangeOfChars {
    val firstChar: Int
    val lastChar: Int
    val charRange get() = firstChar..lastChar
}

sealed class Case : RangeOfChars {
    private val alphabetSize = 26
    override val lastChar get() =  firstChar + alphabetSize - 1
    fun adjustInRange(i: Int) = i - alphabetSize

    object UpperCase : Case() { override val firstChar = 65 }
    object LowerCase : Case() { override val firstChar = 97 }
}
