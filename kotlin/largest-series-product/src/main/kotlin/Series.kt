class Series(val input: String) {

    init {
        require(input.all(Char::isDigit))
    }

    fun getLargestProduct(span: Int): Long {
        require(span in 0..input.length)

        if (input.isEmpty()) return 1

        return (0..input.length - span).map {
            i ->
            input.slice(i..i + span - 1)
                    .map { it.toString().toLong() }
                    .reduce { L1, L2 -> L1 * L2 }
        }.max() ?: 1
    }
}