import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        var grainCount = 1
        while (grainCount < squareNum) {
            grainCount *= 2
        }
        return BigInteger(grainCount.toString())
    }

    fun getTotalGrainCount(): BigInteger = BigInteger("0")
}