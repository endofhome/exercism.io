object PascalsTriangle {
    fun computeTriangle(numberOfRows: Int): List<List<Int>> {
        require(numberOfRows >= 0, { "Rows can't be negative!" })
        return when (numberOfRows) {
            0    -> emptyList()
            else -> computeFor(numberOfRows)
        }
    }

    private fun computeFor(numberOfRows: Int): List<List<Int>> {
        val firstRowPadded = (0 until numberOfRows).map {
            (0..it).map { 1 }
        }.extractFirstRowPadded()

        return summedRows(firstRowPadded, numberOfRows).removePadding()
    }

    private fun summedRows(row: List<Int>, numberOfRows: Int, acc: List<List<Int>> = listOf(row)): List<List<Int>> =
        if (acc.size < numberOfRows) {
            val newAcc: List<List<Int>> = acc + listOf(sumElementsInTwos(row))
            summedRows(newAcc.last(), numberOfRows, newAcc)
        } else {
            acc
        }

    private tailrec fun sumElementsInTwos(row: List<Int>, acc: List<Int> = emptyList()): List<Int> =
        if (row.iterator().hasNext()) {
            val newAcc = acc + listOf(row.take(2).reduce { a, b -> a + b })
            sumElementsInTwos(row.drop(1), newAcc)
        } else {
            acc
        }

    private fun List<List<Int>>.extractFirstRowPadded(): List<Int> =
        this.reversed()
            .mapIndexed { index, list ->
                val zeros = (0..index).map { 0 }
                zeros + list + zeros
            }.reversed().first()

    private fun  List<List<Int>>.removePadding(): List<List<Int>> =
            this.map { it.removePrefixPadding().reversed().removePrefixPadding() }

    private fun List<Int>.removePrefixPadding() = this.dropWhile { it == 0 }
}
