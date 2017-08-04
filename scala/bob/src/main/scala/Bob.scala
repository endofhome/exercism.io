object Bob {
  def response(statement: String): String = {
    if (isShouting(statement)) "Whoa, chill out!"
    else if (statement.endsWith("?")) "Sure."
    else if (statement.replaceAll("\\s*", "") .isEmpty) "Fine. Be that way!"
    else "Whatever."
  }

  private def isShouting(statement: String): Boolean = {
    statement == statement.toUpperCase() & statement.replaceAll("[a-zA-Z]", "") != statement
  }
}
