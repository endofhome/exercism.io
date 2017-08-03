object Bob {
  def response(statement: String): String =
    statement.toUpperCase() match {
      case `statement` => "Whoa, chill out!"
      case _ => "Whatever."
    }
}
