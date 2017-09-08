object PerfectNumbers {
  def classify(i: Int): Either[String, NumberType.NumType] = {
    if (i <= 0) Left("Classification is only possible for natural numbers.")
    else Right(NumberType.values.find(_.definition(i)).get)
  }
}

object NumberType {
  def values = List(Perfect, Abundant, Deficient)

  sealed class NumType(val definition: (Int) => Boolean)

  case object Perfect extends NumType(i => { i.aliquotSum == i })
  case object Abundant extends NumType(i => { i.aliquotSum > i })
  case object Deficient extends NumType(i => { i.aliquotSum < i })

  private implicit class IntExtensions(val i: Int) {
    def aliquotSum = i.factors.sum
    def factors = (1 until i).filter(i % _ == 0).toList
  }
}
