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
        return if (currentSlice.size < sliceSize && inputIterator.hasNext()) {
            val nextElement = inputIterator.next()
            slice(sliceSize, inputIterator.asSequence().toList(), currentSlice.plus(nextElement), slices)
        } else if (currentSlice.size == sliceSize && inputIterator.hasNext()) {
            val nextInput = when (sliceSize) {
                1    -> inputIterator.asSequence().toList()
                else -> listOf(currentSlice.last()) + inputIterator.asSequence().toList()
            }
            slice(sliceSize, nextInput, emptyList(), slices + listOf(currentSlice))
        } else {
            slices + listOf(currentSlice)
        }
    }
}