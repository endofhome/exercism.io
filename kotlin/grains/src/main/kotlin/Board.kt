import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        require(squareNum in 1..64, { "Only integers between 1 and 64 (inclusive) are allowed" } )
        var counter = 1
        var grainCount = BigInteger.valueOf(1L)
        while (counter < squareNum) {
            ++counter
            grainCount *= BigInteger.valueOf(2L)
        }
        return grainCount
    }

    fun getTotalGrainCount(): BigInteger = (1..64).mapNotNull {
        getGrainCountForSquare(it)
    }.toList().sum()
}

fun List<BigInteger>.sum(): BigInteger {
    return this.reduce { acc, bigInteger -> acc.add(bigInteger) }
}