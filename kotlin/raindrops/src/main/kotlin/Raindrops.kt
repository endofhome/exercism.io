object Raindrops {
    fun convert(input: Int): String {
        return when {
            input % 3 == 0 -> "Pling"
            input % 5 == 0 -> "Plang"
            input % 7 == 0 -> "Plong"
            else -> input.toString()
        }
    }
}