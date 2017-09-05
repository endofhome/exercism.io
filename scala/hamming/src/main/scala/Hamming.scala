object Hamming {
  def distance(strandOne: String, strandTwo: String) = {
    val zippedStrands = strandOne.zip(strandTwo)
    Some(zippedStrands.count(pair => pair._1 != pair._2))
  }
}
