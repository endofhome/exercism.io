import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(age: Number) {
    val seconds = age.toLong()
    private val preciseEarthAge = seconds.div(31557600.0)

    fun onEarth() = format(preciseEarthAge)

    fun onMercury() = format(preciseEarthAge.div(0.2408467))

    fun onVenus() = format(preciseEarthAge.div(0.61519726))

    fun onMars() = format(preciseEarthAge.div(1.8808158))

    fun onJupiter(): Double = 0.0

    fun onSaturn(): Double = 0.0

    fun onUranus(): Double = 0.0

    fun onNeptune(): Double = 0.0

    private fun format(highPrecisionNumber: Double): Double {
        return BigDecimal(highPrecisionNumber).setScale(2, RoundingMode.HALF_UP).toDouble()
    }
}