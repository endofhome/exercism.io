class RotationalCipher(private val key: Int) {
    fun encode(input: String) =
        (input.toCharArray().single().toInt() + rotateBy())
            .normaliseInCharRange()
            .toChar()
            .toString()

    private fun rotateBy() =
        if (key >= 26) key - 26
        else key

    private fun Int.normaliseInCharRange() =
        if (this > 122) this - 26
        else this
}
