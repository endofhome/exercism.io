object PascalsTriangle {
    fun computeTriangle(numberOfRows: Int): List<List<Int>> = when (numberOfRows) {
        0    -> emptyList()
        else -> {
            val zeroPaddedRows = (0 until numberOfRows).map {
                (0..it).map { 1 }
            }.padWithZero()

            summedRows(zeroPaddedRows.first(), numberOfRows).removePadding()
        }
    }

    private fun summedRows(row: List<Int>, numberOfRows: Int, acc: List<List<Int>> = listOf(row)): List<List<Int>> =
        if (acc.size < numberOfRows) {
            val newAcc: List<List<Int>> = acc + listOf(sumNextTwoElements(row))
            summedRows(newAcc.last(), numberOfRows, newAcc)
        } else {
            acc
        }

    private tailrec fun sumNextTwoElements(row: List<Int>, acc: List<Int> = emptyList()): List<Int> =
        if (row.iterator().hasNext()) {
            val newAcc = acc + listOf(row.take(2).reduce { a, b -> a + b })
            sumNextTwoElements(row.drop(1), newAcc)
        } else {
            acc.toList()
        }

    private fun List<List<Int>>.padWithZero(): List<List<Int>> =
        this.reversed()
            .mapIndexed { index, list ->
                val zeros = (0..index).map { 0 }
                zeros + list + zeros
            }.reversed()

    private fun  List<List<Int>>.removePadding(): List<List<Int>> =
            this.map { it.removePrefixPadding().reversed().removePrefixPadding() }

    private fun List<Int>.removePrefixPadding() = this.dropWhile { it == 0 }
}
