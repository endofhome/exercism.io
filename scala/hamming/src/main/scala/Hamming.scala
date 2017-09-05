object Hamming {
  def distance(strandOne: String, strandTwo: String) = {
    if (strandOne == strandTwo) Some(0)
    else Some(1)
  }
}
