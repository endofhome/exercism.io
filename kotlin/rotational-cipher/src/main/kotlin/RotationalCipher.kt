class RotationalCipher(private val key: Int) {
    fun encode(input: String) =
        (input.toCharArray().single().toInt() + rotateBy())
            .toChar()
            .toString()

    private fun rotateBy() =
        if (key >= 26) key - 26
        else key
}

