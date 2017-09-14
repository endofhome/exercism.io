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

  def turnLeft(): Robot = {
    bearing match {
      case North => Robot(Bearing.West, coordinates)
      case South => Robot(Bearing.East, coordinates)
      case East => Robot(Bearing.North, coordinates)
      case West => Robot(Bearing.South, coordinates)
    }
  }

  def turnRight(): Robot = {
    bearing match {
      case North => Robot(Bearing.East, coordinates)
      case South => Robot(Bearing.West, coordinates)
      case East => Robot(Bearing.South, coordinates)
      case West => Robot(Bearing.North, coordinates)
    }
  }

  def simulate(string: String): Robot = ???
}

object Bearing extends Enumeration {
  val North, East, South, West = Value
}