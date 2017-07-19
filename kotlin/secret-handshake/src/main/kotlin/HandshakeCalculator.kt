object HandshakeCalculator {
    fun calculateHandshake(int: Int): List<Signal> {
        return when (int) {
            1 -> listOf(Signal.WINK)
            2 -> listOf(Signal.DOUBLE_BLINK)
            else -> throw RuntimeException("Unexpected input")
        }
    }
}