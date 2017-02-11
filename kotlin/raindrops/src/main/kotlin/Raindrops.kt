object Raindrops {
    fun convert(input: Int): String {
        return when {
            input % 3 == 0 -> "Pling"
            input % 5 == 0 -> "Plang"
            else -> input.toString()
        }
    }
}