class Triangle(a: Double, b: Double, c: Double) {
    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    val isScalene: Boolean = false
    val isIsosceles: Boolean = false
    val isEquilateral: Boolean = a == b && b == c
}