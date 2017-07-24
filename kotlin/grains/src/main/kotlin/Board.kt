import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        var counter = 1
        var grainCount = BigInteger.valueOf(1L)
        while (counter < squareNum) {
            ++counter
            grainCount *= BigInteger.valueOf(2L)
        }
        return grainCount
    }

    fun getTotalGrainCount(): BigInteger = BigInteger.valueOf(0L)
}