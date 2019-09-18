import Case.UpperCase
import Case.LowerCase

class RotationalCipher(private val key: Int) {
    fun encode(input: String) =
        input.toCharArray().map { char ->
            if (char.isLetter()) {
                char.toInt()
                    .let { charInt -> rotate(charInt, charInt + key) }
                    .toChar()
            } else char
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

fun rotate(initialChar: Int, rotatedChar: Int): Int {
    val cases = listOf(UpperCase, LowerCase)

    return cases.find {
        case -> initialChar in case.charRange && rotatedChar > case.lastChar
    }?.adjustInRange(rotatedChar)
        ?: rotatedChar
}
