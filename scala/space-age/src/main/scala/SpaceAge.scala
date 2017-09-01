import scala.math.BigDecimal.RoundingMode.HALF_UP

case class SpaceAge(seconds: Long) {
  private val PreciseEarthOrbitalPeriod = seconds / 31557600d

  val onEarth: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(1d)
  val onMercury: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(0.2408467d)
  val onVenus: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(0.61519726d)
  val onMars: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(1.8808158)
  val onJupiter: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(11.862615d)
  val onSaturn: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(29.447498d)
  val onUranus: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(84.016846d)
  val onNeptune: Double = ageOnPlanetWhenEarthOrbitalPeriodIs(164.79132d)

  private def ageOnPlanetWhenEarthOrbitalPeriodIs(orbitalPeriodInEarthYears: Double) = {
    format(PreciseEarthOrbitalPeriod / orbitalPeriodInEarthYears)
  }

  private def format(double: Double) = {
    BigDecimal(double).setScale(2, HALF_UP).toDouble
  }
}
