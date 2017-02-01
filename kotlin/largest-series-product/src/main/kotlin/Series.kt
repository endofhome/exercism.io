class Series(val input: String) {
    fun getLargestProduct(span: Int): Long {
        val inputAsListOfLong = input.map { it.toString().toLong() }.toList()
        return inputAsListOfLong.mapIndexed { i, l ->
            inputAsListOfLong
                    .slice(i.rangeTo(upperForRange(i, span)))
                    .reduce { L1, L2 -> L1 * L2 }
        }.sorted().last()
    }

    private fun upperForRange(i: Int, span: Int): Int {
        return when (i + span - 1 < input.length) {
            true -> i + span -1
            else -> upperForRange(i, span -1)
        }
    }
}