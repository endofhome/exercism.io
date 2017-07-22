class Triangle(val a: Double, val b: Double, val c: Double) {
    constructor(a: Int, b: Int, c: Int): this(a.toDouble(), b.toDouble(), c.toDouble())
    init {
        require(a != 0.0 && b != 0.0 && c != 0.0)
        require(isATriangle())
    }

    private val distinctSideLengths = listOf(a, b, c).toSet().size
    val isScalene: Boolean = false
    val isIsosceles: Boolean = distinctSideLengths <= 2
    val isEquilateral: Boolean = distinctSideLengths == 1

    private fun isATriangle(): Boolean {
        val sides = listOf(a, b, c)
        return sides.mapIndexed { sidesIndex, thisSide ->
            val others = sides.filterIndexed { i, _ -> i != sidesIndex }
            others[0] + others [1] >= thisSide
        }.toList().all { it }
    }
}