import Bearing.{North, South, East, West}

case class Robot(bearing: Bearing.Value, coordinates: (Int, Int)) {

  def advance: Robot = {
    bearing match {
      case North => Robot(bearing, coordinates.copy(_2 = 1))
      case South => Robot(bearing, coordinates.copy(_2 = -1))
      case East => Robot(bearing, coordinates.copy(_1 = 1))
      case West => Robot(bearing, coordinates.copy(_1 = -1))
    }
  }

  def turnLeft(): Robot = ???

  def turnRight(): Robot = ???

  def simulate(string: String): Robot = ???
}

object Bearing extends Enumeration {
  val North, East, South, West = Value
}