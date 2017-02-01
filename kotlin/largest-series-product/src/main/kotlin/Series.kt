class Series(val input: String) {
    fun getLargestProduct(span: Int): Long {
        val inputAsListOfLong = input.map { it.toString().toLong() }.toList()
        val listOfProducts = inputAsListOfLong.mapIndexed { i, l ->
            inputAsListOfLong
                    .slice(appropriateRange(i, span))
                    .reduce { L1, L2 -> L1 * L2 }
        }.sorted()
        return listOfProducts.getOrElse(listOfProducts.lastIndex, { 1L })
    }

    private fun appropriateRange(i: Int, span: Int): IntRange {
        return when (i + span - 1 < input.length) {
            true -> i.rangeTo(i + span -1)
            else -> (input.lastIndex - (span -1)).rangeTo(input.lastIndex)
        }
    }
}