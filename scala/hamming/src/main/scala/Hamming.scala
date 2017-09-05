object Hamming {
  def distance(strandOne: String, strandTwo: String): Option[Integer] = {
    if (strandOne.length != strandTwo.length) None
    else {
      val zippedStrands = strandOne.zip(strandTwo)
      Some(zippedStrands.count(pair => pair._1 != pair._2))
    }
  }
}
