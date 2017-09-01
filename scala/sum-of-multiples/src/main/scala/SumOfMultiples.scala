object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(_.multiplesUpTo(limit)).sum
  }

  private implicit class IntExtensions(val subject: Int) {
    def multiplesUpTo(limit: Int): Set[Int] = {
      (0 until limit).filter(_ % subject == 0).toSet
    }
  }
}

