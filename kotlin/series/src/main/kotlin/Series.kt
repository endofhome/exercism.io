object Series {
    fun slices(sliceSize: Int, inputString: String): List<List<Int>> =
        inputString.map { Integer.parseInt(it.toString()) }.let { inputInts ->
            when {
                inputInts.isEmpty() -> emptyList()
                else                -> slice(sliceSize, inputInts)
            }
        }

    private fun slice(sliceSize: Int, inputInts: List<Int>, currentSlice: List<Int> = emptyList(), slices: List<List<Int>> = emptyList()): List<List<Int>> {
        val inputIterator = inputInts.listIterator()
        return when {
            currentSlice.size < sliceSize && inputIterator.hasNext()  -> takeABiggerSlice(inputIterator, sliceSize, currentSlice, slices)
            currentSlice.size == sliceSize && inputIterator.hasNext() -> takeAnotherSlice(sliceSize, inputIterator, currentSlice, slices)
            else                                                      -> slices + listOf(currentSlice)
        }
    }

    private fun takeAnotherSlice(sliceSize: Int, inputIterator: ListIterator<Int>, currentSlice: List<Int>, slices: List<List<Int>>): List<List<Int>> {
        val nextInput = when (sliceSize) {
            1 -> inputIterator.toList()
            else -> listOf(currentSlice.last()) + inputIterator.toList()
        }
        return slice(sliceSize, nextInput, emptyList(), slices + listOf(currentSlice))
    }

    private fun takeABiggerSlice(inputIterator: ListIterator<Int>, sliceSize: Int, currentSlice: List<Int>, slices: List<List<Int>>): List<List<Int>> {
        val nextElement = inputIterator.next()
        return slice(sliceSize, inputIterator.toList(), currentSlice.plus(nextElement), slices)
    }

    private fun ListIterator<Int>.toList() = this.asSequence().toList()
}