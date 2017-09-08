import NumberType.NumberType

object PerfectNumbers {
  type T = Int
  type R = Int
  val numberTypeMappings: Map[NumberType, (T, R) => Boolean] = Map(
    (NumberType.Perfect, (T, R) => { T == R }),
    (NumberType.Abundant, (T, R) => { T > R }),
    (NumberType.Deficient, (T, R) => { T < R })
  )

  def classify(int: Int): Either[String, NumberType] = {
    if (int <= 0) Left("Classification is only possible for natural numbers.")
    else Right(numberTypeMappings.find(_._2(int.factors.sum, int)).get._1)
  }

  private implicit class IntExtensions(val i: Int) {
    def factors = (1 until i).filter(i % _ == 0).toList
  }
}

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Abundant, Deficient = Value
}
