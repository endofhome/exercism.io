object SumOfMultiples {
    fun sum(of: Set<Int>, upTo: Int): Int = of.flatMap {
        it.multiples(upTo)
    }.toList().sum()
}

fun Int.multiples(upTo: Int) = (0..upTo -1).mapNotNull {
    when (it % this == 0) {
        true -> it
        false -> null
    }
}.toList()