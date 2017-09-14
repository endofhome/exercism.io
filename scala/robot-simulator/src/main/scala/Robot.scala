case class Robot(bearing: Bearing.Value, coordinates: (Int, Int)) {
  def advance: Robot = ???
  def turnLeft(): Robot = ???
  def turnRight(): Robot = ???
  def simulate(string: String): Robot = ???
}

object Bearing extends Enumeration {
  val North, East, South, West = Value
}