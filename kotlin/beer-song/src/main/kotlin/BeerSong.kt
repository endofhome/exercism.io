object BeerSong {
    val lyrics: String = ""

    fun verse(number: Int): String {
        return when (number) {
            0 -> "${numberOfBottles(0)} of beer on the wall, ${numberOfBottles(0)} of beer.\nGo to the store and buy some more, ${numberOfBottles(-1)} of beer on the wall.\n".capitalize()
            1 -> "${numberOfBottles(1)} of beer on the wall, ${numberOfBottles(1)} of beer.\nTake it down and pass it around, ${numberOfBottles(0)} of beer on the wall.\n"
            else -> "${numberOfBottles(number)} of beer on the wall, ${numberOfBottles(number)} of beer.\nTake one down and pass it around, ${numberOfBottles(number -1)} of beer on the wall.\n"
        }
    }

    private fun numberOfBottles(number: Int): String = when (number) {
        -1 -> numberOfBottles(99)
        0 -> "no more bottles"
        1 -> "1 bottle"
        else -> "$number bottles"
    }

    fun verses(startNumber: Int, endNumber: Int): String = ""
}