class School {
  type DB = Map[Int, Seq[String]]
  var data: DB = Map.empty

  def add(name: String, g: Int) = {
    data = data ++ Map(g -> (data.getOrElse(g, Seq.empty) ++ Seq(name)))
  }

  def db: DB = data

  def grade(g: Int): Seq[String] = ???

  def sorted: DB = ???
}
