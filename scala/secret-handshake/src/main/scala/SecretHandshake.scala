object SecretHandshake {

  def commands(input: Int): List[String] = {
    val binary = input.toBinaryString
    val shouldReverse = binary.length == 5 && binary.charAt(0) == '1'
    val binaryWithoutSwitch = removeSwitchFrom(binary, shouldReverse)

    binaryWithoutSwitch.reverse.zipWithIndex
      .filter( _._1 == '1' )
      .map(
      _._2 match {
        case 0 => "wink"
        case 1 => "double blink"
        case 2 => "close your eyes"
        case 3 => "jump"
      }
    ).toList.reverseIf(shouldReverse)
  }

  def removeSwitchFrom(binary: String, shouldReverse: Boolean) = {
    if (shouldReverse) binary.substring(1)
    else binary

  }

  private implicit class ListOfStringExtensions(val l: List[String]) {
    def reverseIf(shouldReverse: Boolean): List[String] = {
      if (shouldReverse) l.reverse
      else l
    }
  }
}
