object SecretHandshake {
  def commands(input: Int): List[String] = {
    input.toBinaryString.length() match {
      case 1 => List("wink")
      case 2 => List("double blink")
      case 3 => List("close your eyes")
      case 4 => List("jump")
    }
  }
}
