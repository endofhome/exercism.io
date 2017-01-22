import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(age: Number) {
    val seconds: Int = age.toInt()

    fun onEarth(): Double {
        val earthYears: Double = seconds.div(31557600.0)
        return BigDecimal(earthYears).setScale(2, RoundingMode.UP).toDouble()
    }

    fun onMercury(): Double = 0.0

    fun onVenus(): Double = 0.0

    fun onMars(): Double = 0.0

    fun onJupiter(): Double = 0.0

    fun onSaturn(): Double = 0.0

    fun onUranus(): Double = 0.0

    fun onNeptune(): Double = 0.0
}