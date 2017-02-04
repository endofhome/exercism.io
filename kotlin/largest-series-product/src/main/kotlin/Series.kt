class Series(val input: String) {

    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        require(span in 0..input.length)

        val inputAsListOfLong = input.map { it.toString().toLong() }.toList()
        return inputAsListOfLong.mapIndexed { i, l ->
            inputAsListOfLong
                    .slice(appropriateRange(i, span))
                    .reduce { L1, L2 -> L1 * L2 }
        }.max() ?: 1
    }

    private fun appropriateRange(i: Int, span: Int): IntRange {
        return when (i + span - 1 < input.length) {
            true -> i.rangeTo(i + span - 1)
            else -> (input.lastIndex - (span - 1)).rangeTo(input.lastIndex)
        }
    }
}