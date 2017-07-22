class Triangle(val a: Double, val b: Double, val c: Double) {
    constructor(a: Int, b: Int, c: Int): this(a.toDouble(), b.toDouble(), c.toDouble())
    init {
        require(listOf(a, b, c).map { it != 0.0 }.all { it })
        require(isATriangle())
    }

    private val distinctSides = listOf(a, b, c).toSet().size
    val isScalene: Boolean = distinctSides == 3
    val isIsosceles: Boolean = distinctSides <= 2
    val isEquilateral: Boolean = distinctSides == 1

    private fun isATriangle(): Boolean {
        val sides = listOf(a, b, c)
        return sides.mapIndexed { sidesIndex, thisSide ->
            val others = sides.filterIndexed { i, _ -> i != sidesIndex }
            others[0] + others [1] >= thisSide
        }.toList().all { it }
    }
}