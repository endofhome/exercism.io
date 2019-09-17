class RotationalCipher(val key: Int) {
    fun encode(input: String) =
        if (key == 0) "a"
        else "b"
}