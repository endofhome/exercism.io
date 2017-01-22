import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(age: Number) {
    val seconds: Int = age.toInt()

    fun onEarth(): Double {
        return format(seconds.div(31557600.0))
    }

    fun onMercury(): Double {
        return format(onEarth().div(0.2408467))
    }

    fun onVenus(): Double = 0.0

    fun onMars(): Double = 0.0

    fun onJupiter(): Double = 0.0

    fun onSaturn(): Double = 0.0

    fun onUranus(): Double = 0.0

    fun onNeptune(): Double = 0.0

    private fun format(highPrecisionNumber: Double): Double {
        return BigDecimal(highPrecisionNumber).setScale(2, RoundingMode.HALF_DOWN).toDouble()
    }
}