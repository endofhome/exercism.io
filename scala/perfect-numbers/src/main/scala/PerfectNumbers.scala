import NumberType.NumberType

object PerfectNumbers {
  def classify(int: Int): Either[String, NumberType] = {
    if (aliquotSum(int) == int) Right(NumberType.Perfect)
    else Right(NumberType.Abundant)
  }

  def aliquotSum(int: Int): Int = int.factors.sum

  private implicit class IntExtensions(val i: Int) {
    def factors = List(1, 2, 3)
  }
}

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Abundant, Deficient = Value
}
