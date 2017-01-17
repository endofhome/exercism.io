class Year(year: Int) {
    val isLeap = year.mod(4) == 0 && (year.mod(100) != 0 || year.mod(400) == 0)
}