class RotationalCipher(private val key: Int) {
    private val upperCaseChars = 65..90
    private val lowerCaseChars = 97..122
    private val alphabetSize = 26

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
        if (this.first in upperCaseChars && this.second > upperCaseChars.last) this.second - alphabetSize
        else if (this.first in lowerCaseChars && this.second > lowerCaseChars.last) this.second - alphabetSize
        else this.second
}
