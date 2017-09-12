object SecretHandshake {
  def commands(input: Int): List[String] = {
    input.toBinaryString.reverse.zipWithIndex
      .filter(_._1 == '1' )
      .map(
      _._2 match {
        case 0 => "wink"
        case 1 => "double blink"
        case 2 => "close your eyes"
        case 3 => "jump"
      }
    ).toList
  }
}
