object HandshakeCalculator {
    fun calculateHandshake(int: Int): List<Signal> {
        val binary = Integer.toBinaryString(int)
        return (binary.length.let {
            when (it) {
                1 -> listOf(Signal.WINK)
                2 -> listOf(Signal.DOUBLE_BLINK)
                3 -> listOf(Signal.CLOSE_YOUR_EYES)
                4 -> listOf(Signal.JUMP)
                else -> throw RuntimeException("Unexpected input")
            }
        })
    }
}