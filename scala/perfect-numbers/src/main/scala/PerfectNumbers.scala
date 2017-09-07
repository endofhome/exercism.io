import NumberType.NumberType

object PerfectNumbers {
  def classify(int: Int): Either[String, NumberType] = {
    if (int <= 0) Left("Classification is only possible for natural numbers.")
    else if (aliquotSum(int) == int) Right(NumberType.Perfect)
    else if (aliquotSum(int) > int) Right(NumberType.Abundant)
    else Right(NumberType.Deficient)
  }

  def aliquotSum(int: Int): Int = int.factors.sum

  private implicit class IntExtensions(val i: Int) {
    def factors = (1 until i).filter(i % _ == 0).toList
  }
}

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Abundant, Deficient = Value
}
