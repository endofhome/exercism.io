object Leap {
  def leapYear(year: Int): Boolean = {
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) true
    else false
  }
}
