object SecretHandshake {

  def commands(input: Int): List[String] = {
    val handshake = handshakeFrom(input)
    handshake.binary.reverse.zipWithIndex
      .filter( _._1 == '1' )
      .map(
      _._2 match {
        case 0 => "wink"
        case 1 => "double blink"
        case 2 => "close your eyes"
        case 3 => "jump"
      }
    ).toList.reverseIf(handshake.shouldBeReversed)
  }

  private def handshakeFrom(input: Int): Handshake = {
    val binary = input.toBinaryString
    val shouldBeReversed = binary.length == 5 && binary.charAt(0) == '1'
    val binaryWithoutSwitch = removeSwitchIfPresent(binary, shouldBeReversed)
    Handshake(binaryWithoutSwitch, shouldBeReversed)
  }

  private def removeSwitchIfPresent(binary: String, shouldBeReversed: Boolean) = {
    if (shouldBeReversed) binary.substring(1)
    else binary
  }

  private implicit class ListOfStringExtensions(val list: List[String]) {
    def reverseIf(shouldBeReversed: Boolean): List[String] = {
      if (shouldBeReversed) list.reverse
      else list
    }
  }

  case class Handshake(binary: String, shouldBeReversed: Boolean)
}
