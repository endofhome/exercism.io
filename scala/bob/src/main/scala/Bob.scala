object Bob {
  def response(statement: String): String = {
    statement match {
      case Shouting(_) => "Whoa, chill out!"
      case Question(_) => "Sure."
      case Silence(_) => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  private object Shouting {
    def unapply(shout: String): Option[String] = {
      if (shout == shout.toUpperCase() && shout.replaceAll("[a-zA-Z]", "") != shout) Some(shout) else None
    }
  }

  private object Question {
    def unapply(question: String): Option[String] = {
      if (question.trim.endsWith("?")) Some(question) else None
    }
  }

  private object Silence {
    def unapply(silence: String): Option[String] = {
      if (silence.replaceAll("\\s*", "").isEmpty) Some(silence) else None
    }
  }
}
