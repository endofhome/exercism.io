object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(f => f.multiplesUpTo(limit)).sum
  }

  private implicit class IntExtensions(val subject: Int) {
    def multiplesUpTo(limit: Int): Set[Int] = {
      (0 until limit).filter(i => i % subject == 0).toSet
    }
  }
}

