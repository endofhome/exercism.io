class School {
  type DB = Map[Int, Seq[String]]
  var data: DB = Map()

  def add(name: String, g: Int) = {
    data = data + (g -> Seq(name))
  }

  def db: DB = data

  def grade(g: Int): Seq[String] = ???

  def sorted: DB = ???
}
