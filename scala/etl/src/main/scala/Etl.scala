object Etl {
  def transform(inputMap: Map[Int, Seq[String]]) = {
    inputMap.flatMap(pair => pair._2.map(_.toLowerCase -> pair._1))
  }
}
