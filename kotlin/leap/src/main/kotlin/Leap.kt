class Year(private val year: Int) {
    val isLeap = year.mod(4).equals(0)
}
