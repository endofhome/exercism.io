object Bob {
  def response(statement: String): String = {
    if (statement.isShouting) "Whoa, chill out!"
    else if (statement.trim.endsWith("?")) "Sure."
    else if (statement.replaceAll("\\s*", "") .isEmpty) "Fine. Be that way!"
    else "Whatever."
  }

  private implicit class StringExtensions(val s: String){
    def isShouting: Boolean = {
      s == s.toUpperCase() && s.replaceAll("[a-zA-Z]", "") != s
    }
  }
}
