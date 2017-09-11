object SecretHandshake {
  def commands(input: Int) = {
    if (input == 1) List("wink")
    else if (input == 2) List("double blink")
    else List("close your eyes")
  }
}
