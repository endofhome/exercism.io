import scala.math.BigDecimal.RoundingMode.UP

case class SpaceAge(seconds: Long) {
  val onEarth: Double = BigDecimal(seconds / 31557600d).setScale(2, UP).toDouble
  val onMercury: Double = 0
  val onVenus: Double = 0
  val onMars: Double = 0
  val onJupiter: Double = 0
  val onSaturn: Double = 0
  val onUranus: Double = 0
  val onNeptune: Double = 0
}
