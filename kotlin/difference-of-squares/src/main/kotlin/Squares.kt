class Squares(private val upper: Int) {
    fun squareOfSum(): Int {
        val sum = 1.rangeTo(upper).sum()
        return sum.times(sum)
    }

    fun  sumOfSquares(): Int {
        return 1.rangeTo(upper).map {
            it.times(it)
        }.toList().sum()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}