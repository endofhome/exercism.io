import scala.math.BigDecimal.RoundingMode.HALF_UP

case class SpaceAge(seconds: Long) {
  private val PreciseEarthOrbitalPeriod = seconds / 31557600d

  val onEarth: Double = ageFor(1d)
  val onMercury: Double = ageFor(0.2408467d)
  val onVenus: Double = ageFor(0.61519726d)
  val onMars: Double = ageFor(1.8808158)
  val onJupiter: Double = ageFor(11.862615d)
  val onSaturn: Double = ageFor(29.447498d)
  val onUranus: Double = ageFor(84.016846d)
  val onNeptune: Double = ageFor(164.79132d)

  private def ageFor(orbitalPeriodInEarthYears: Double) = {
    format(PreciseEarthOrbitalPeriod / orbitalPeriodInEarthYears)
  }

  private def format(double: Double) = {
    BigDecimal(double).setScale(2, HALF_UP).toDouble
  }
}
