object PerfectNumbers {
  def classify(int: Int): Either[String, NumberType.NumType] = {
    if (int <= 0) Left("Classification is only possible for natural numbers.")
    else Right(NumberType.values.find(_.definition(int.factors.sum, int)).get)
  }

  private implicit class IntExtensions(val i: Int) {
    def factors = (1 until i).filter(i % _ == 0).toList
  }
}

object NumberType {
  def values = List(Perfect, Abundant, Deficient)

  sealed class NumType(val definition: (Int, Int) => Boolean)

  case object Perfect extends NumType((A, B) => { A == B })
  case object Abundant extends NumType((A, B) => { A > B })
  case object Deficient extends NumType((A, B) => { A < B })
}
