import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(val seconds: Long) {
    private val preciseEarthAge = seconds.div(31557600.0)

    fun onEarth() = format(preciseEarthAge)

    fun onMercury() = format(preciseEarthAge.div(0.2408467))

    fun onVenus() = format(preciseEarthAge.div(0.61519726))

    fun onMars() = format(preciseEarthAge.div(1.8808158))

    fun onJupiter() = format(preciseEarthAge.div(11.862615))

    fun onSaturn() = format(preciseEarthAge.div(29.447498))

    fun onUranus() = format(preciseEarthAge.div(84.016846))

    fun onNeptune() = format(preciseEarthAge.div(164.79132))

    private fun format(highPrecisionNumber: Double): Double {
        return BigDecimal(highPrecisionNumber).setScale(2, RoundingMode.HALF_UP).toDouble()
    }
}