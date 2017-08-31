import scala.math.BigDecimal.RoundingMode.HALF_UP

case class SpaceAge(seconds: Long) {
  private val PRECISE_EARTH_ORBITAL_PERIOD = seconds / 31557600d

  val onEarth: Double = format(PRECISE_EARTH_ORBITAL_PERIOD)
  val onMercury: Double = format(PRECISE_EARTH_ORBITAL_PERIOD / 0.2408467d)
  val onVenus: Double = format(PRECISE_EARTH_ORBITAL_PERIOD /  0.61519726d)
  val onMars: Double = 0
  val onJupiter: Double = 0
  val onSaturn: Double = 0
  val onUranus: Double = 0
  val onNeptune: Double = 0

  private def format(double: Double) = {
    BigDecimal(double).setScale(2, HALF_UP).toDouble
  }
}
