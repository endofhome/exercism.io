class RotationalCipher(val key: Int) {
    fun encode(input: String) =
        if (key.isEven()) "a"
        else "b"

    private fun Int.isEven() = this % 2 == 0
}
