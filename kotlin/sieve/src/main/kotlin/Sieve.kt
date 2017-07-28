object Sieve {
    fun primesUpTo(input: Int): List<Int> {
        val resultMap: MutableMap<Int, Status> =
                (2..input).map { it to Status.UNMARKED }
                        .toMap().toMutableMap()
        resultMap.toSortedMap().firstKey().let {
            markMultiples(it, input, resultMap)
        }
        return resultMap.filter { it.value == Status.UNMARKED }.keys.toList()
    }

    private fun markMultiples(root: Int, input: Int, resultMap: MutableMap<Int, Status>) {
        resultMap.keys
                .filter { resultMap[it] == Status.UNMARKED }
                .map { toTest ->
            val multiples = (input.downTo(toTest)).filter { it % toTest == 0 && it != toTest }
            multiples.map { multiple ->
                resultMap[multiple] = Status.MARKED
            }
        }
        if (root < input) { markMultiples(root + 1, input, resultMap) }
    }
}

enum class Status {
    UNMARKED,
    MARKED
}