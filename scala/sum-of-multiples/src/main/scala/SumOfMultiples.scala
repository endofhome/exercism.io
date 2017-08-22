object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(f => f.multiples(limit)).sum
  }

  private implicit class IntExtensions(val subject: Int) {
    def multiples(limit: Int): Set[Int] = {
      (0 until limit).filter(i => i % subject == 0).toSet
    }
  }
}

