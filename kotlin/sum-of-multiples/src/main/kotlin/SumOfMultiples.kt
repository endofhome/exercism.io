object SumOfMultiples {
    fun sum(of: Set<Int>, upTo: Int): Int {
        var result = 0
        of.forEach {
            if (it < upTo) { result += it }
        }
        return result
    }
}