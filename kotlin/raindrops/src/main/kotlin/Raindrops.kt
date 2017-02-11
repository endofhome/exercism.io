object Raindrops {
    fun convert(input: Int): String {
        return when {
            input % 3 == 0 -> "Pling"
            else -> input.toString()
        }
    }
}