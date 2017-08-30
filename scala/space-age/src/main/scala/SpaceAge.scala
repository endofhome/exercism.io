import scala.math.BigDecimal.RoundingMode.HALF_UP

case class SpaceAge(seconds: Long) {
  val onEarth: Double = format(seconds / 31557600d)
  val onMercury: Double = format(onEarth / 0.2408467d)
  val onVenus: Double = 0
  val onMars: Double = 0
  val onJupiter: Double = 0
  val onSaturn: Double = 0
  val onUranus: Double = 0
  val onNeptune: Double = 0

  private def format(double: Double) = {
    BigDecimal(double).setScale(2, HALF_UP).toDouble
  }
}
