object Bob {
  def response(statement: String): String =
    if (statement == statement.toUpperCase()) "Whoa, chill out!"
    else if (statement.endsWith("?")) "Sure."
    else "Whatever."
}
