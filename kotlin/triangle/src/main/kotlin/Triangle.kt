class Triangle(a: Double, b: Double, c: Double) {

    init {
        require(a != 0.0 && b != 0.0 && c != 0.0)
    }
    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    val isScalene: Boolean = false
    val isIsosceles: Boolean = false
    val isEquilateral: Boolean = a == b && b == c
}