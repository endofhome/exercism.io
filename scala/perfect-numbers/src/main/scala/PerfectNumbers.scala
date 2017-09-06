import NumberType.NumberType

object PerfectNumbers {
  def classify(int: Int): Either[String, NumberType] = Right(NumberType.Perfect)
}

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Abundant, Deficient = Value
}
