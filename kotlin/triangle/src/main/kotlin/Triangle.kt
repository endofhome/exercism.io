class Triangle(i: Double, i1: Double, i2: Double) {
    constructor(i: Int, i1: Int, i2: Int) : this(i.toDouble(), i1.toDouble(), i2.toDouble())

    val isScalene: Boolean = false
    val isIsosceles: Boolean = false
    val isEquilateral: Boolean = true
}