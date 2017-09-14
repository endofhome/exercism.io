case class Robot(bearing: Bearing.Value, coordinates: (Int, Int)) {

  def advance: Robot = {
    if (bearing == Bearing.North) {
      Robot(bearing, coordinates.copy(_2 = 1))
    }
    else if (bearing == Bearing.East) {
      Robot(bearing, coordinates.copy(_1 = 1))
    }
    else this
  }

  def turnLeft(): Robot = ???
  def turnRight(): Robot = ???
  def simulate(string: String): Robot = ???
}

object Bearing extends Enumeration {
  val North, East, South, West = Value
}