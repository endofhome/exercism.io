import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        require(squareNum in 1..64, { "Only integers between 1 and 64 (inclusive) are allowed" } )

        var grainsForSquare = BigInteger.ONE
        (2..squareNum).map {
            grainsForSquare = grainsForSquare.multiply(BigInteger.valueOf(2L))
        }
        return grainsForSquare
    }

    fun getTotalGrainCount(): BigInteger = (1..64).mapNotNull {
        getGrainCountForSquare(it)
    }.toList().sum()
}

fun List<BigInteger>.sum(): BigInteger {
    return this.reduce { acc, bigInteger -> acc.add(bigInteger) }
}