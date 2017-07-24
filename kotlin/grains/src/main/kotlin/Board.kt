import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        var counter = 1
        var grainCount = 1
        while (counter < squareNum) {
            ++counter
            grainCount *= 2
        }
        return BigInteger.valueOf(grainCount.toLong())
    }

    fun getTotalGrainCount(): BigInteger = BigInteger.valueOf(0L)
}