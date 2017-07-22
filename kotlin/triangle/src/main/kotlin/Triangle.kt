class Triangle(a: Double, b: Double, c: Double) {
    constructor(a: Int, b: Int, c: Int): this(a.toDouble(), b.toDouble(), c.toDouble())
    init {
        require(a != 0.0 && b != 0.0 && c != 0.0)
    }

    private val differentiatedSideLengths = listOf(a, b, c).toSet().size
    val isScalene: Boolean = false
    val isIsosceles: Boolean = differentiatedSideLengths <= 2
    val isEquilateral: Boolean = differentiatedSideLengths == 1
}