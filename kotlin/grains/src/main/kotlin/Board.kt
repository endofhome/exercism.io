import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        require(squareNum in 1..64, { "Only integers between 1 and 64 (inclusive) are allowed" } )

        return BigInteger.valueOf(2L).pow(squareNum -1)
    }

    fun getTotalGrainCount(): BigInteger = (1..64).mapNotNull {
        getGrainCountForSquare(it)
    }.toList().sum()
}

private fun List<BigInteger>.sum(): BigInteger {
    return this.reduce { acc, bigInteger -> acc.add(bigInteger) }
}