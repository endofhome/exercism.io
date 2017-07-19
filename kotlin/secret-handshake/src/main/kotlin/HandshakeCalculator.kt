import java.util.function.BinaryOperator

object HandshakeCalculator {
    fun calculateHandshake(int: Int): List<Signal> {
        val binary = Integer.toBinaryString(int)
        return (binary.length.let {
            when {
                it == 1 -> listOf(Signal.WINK)
                it == 2 -> listOf(Signal.DOUBLE_BLINK)
                it == 3 -> listOf(Signal.CLOSE_YOUR_EYES)
                else -> throw RuntimeException("Unexpected input")
            }
        })
    }
}