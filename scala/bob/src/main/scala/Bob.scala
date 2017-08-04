object Bob {
  def response(statement: String): String = {
    statement match {
      case s if s.isShouting => "Whoa, chill out!"
      case s if s.trim.endsWith("?") => "Sure."
      case s if s.replaceAll("\\s*", "").isEmpty => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  implicit class StringExtensions(val s: String){
    def isShouting: Boolean = {
      s == s.toUpperCase() & s.replaceAll("[a-zA-Z]", "") != s
    }
  }
}
