import Case.UpperCase
import Case.LowerCase

class RotationalCipher(private val key: Int) {
    private val cases = listOf(UpperCase, LowerCase)

    fun encode(input: String) =
        input.toCharArray().map { char ->
            if (char.isLetter()) {
                char.toInt()
                    .let { charInt -> charInt to charInt + key }
                    .normaliseInCharRange()
                    .toChar()
            } else char
        }.joinToString("")

    private fun Pair<Int, Int>.normaliseInCharRange(): Int =
        cases.find { this.first in it.charRange() && this.second > it.lastChar }
            ?.keepInRange(this.second)
            ?: this.second
}

interface RangeOfChars {
    val firstChar: Int
    val lastChar: Int
}

sealed class Case : RangeOfChars {
    private val alphabetSize = 26
    override val lastChar get() =  firstChar + alphabetSize - 1
    fun charRange() = firstChar..lastChar
    fun keepInRange(i: Int) = i - alphabetSize


    object UpperCase : Case() { override val firstChar = 65 }
    object LowerCase : Case() { override val firstChar = 97 }
}
