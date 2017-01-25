object BeerSong {
    val lyrics: String = verses(99, 0)

    fun verse(number: Int): String {
        require(number >= 0, { "Beer song verse can't be negative" })
        require(number <= 99, { "Beer song only goes up to verse 99" })

        return when {
            number == 0 -> "${numberOfBottles(0)} of beer on the wall, ${numberOfBottles(0)} of beer.\nGo to the store and buy some more, ${numberOfBottles(-1)} of beer on the wall.\n".capitalize()
            number == 1 -> "${numberOfBottles(1)} of beer on the wall, ${numberOfBottles(1)} of beer.\nTake it down and pass it around, ${numberOfBottles(0)} of beer on the wall.\n"
            else -> "${numberOfBottles(number)} of beer on the wall, ${numberOfBottles(number)} of beer.\nTake one down and pass it around, ${numberOfBottles(number -1)} of beer on the wall.\n"
        }
    }

    private fun numberOfBottles(number: Int): String = when (number) {
        -1 -> numberOfBottles(99)
        0 -> "no more bottles"
        1 -> "1 bottle"
        else -> "$number bottles"
    }

    fun verses(startNumber: Int, endNumber: Int): String {
        val verseNumbers = startNumber downTo endNumber
        return verseNumbers.map {
            verse(it)
        }.joinToString("\n")
    }
}