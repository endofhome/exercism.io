class Squares(private val upper: Int) {
    fun squareOfSum(): Int {
        val sum = 1.rangeTo(upper).sum()
        return sum.times(sum)
    }

    fun  sumOfSquares(): Int = 0

    fun difference(): Int = 0
}