object SecretHandshake {
  def commands(input: Int) = {
    if (input.toBinaryString == "1") List("wink")
    else if (input.toBinaryString == "10") List("double blink")
    else List("close your eyes")
  }
}
