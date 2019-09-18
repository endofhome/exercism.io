import Case.UpperCase
import Case.LowerCase

class RotationalCipher(private val key: Int) {
    fun encode(input: String) =
        input.toCharArray().map { char ->
            when {
                char.isLetter() -> char.rotateBy(key)
                else            -> char
            }
        }.joinToString("")

}

interface RangeOfChars {
    val firstChar: Int
    val lastChar: Int
}

sealed class Case : RangeOfChars {
    private val alphabetSize = 26
    val charRange get() = firstChar..lastChar
    override val lastChar get() =  firstChar + alphabetSize - 1
    fun adjustInRange(i: Int) = i - alphabetSize


    object UpperCase : Case() { override val firstChar = 65 }
    object LowerCase : Case() { override val firstChar = 97 }
}

fun Char.rotateBy(key: Int): Char {
    val cases = listOf(UpperCase, LowerCase)
    val charAsInt = this.toInt()
    val rotatedChar = charAsInt + key

    val rotatedCharAsInt = cases.find {
        case -> charAsInt in case.charRange && rotatedChar > case.lastChar
    }?.adjustInRange(rotatedChar)
        ?: rotatedChar

    return rotatedCharAsInt.toChar()
}
