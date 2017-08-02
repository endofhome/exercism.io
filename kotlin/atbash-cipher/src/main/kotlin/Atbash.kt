object Atbash {
    val alphabet = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z')

    fun encode(input: String): String =
        basicTransform(input).maxFiveCharsPerWord()

    fun decode(input: String): String = basicTransform(input)

    private fun basicTransform(input: String): String {
        return input.filter { it.isLetterOrDigit() }
                .map {
                    when (it.isLetter()) {
                        true -> flip(it)
                        false -> it
                    }
                }.toList().joinToString("")
    }

    private fun flip(letter: Char): Char {
        val charPos = alphabet.indexOf(letter.toLowerCase())
        return alphabet.reversed()[charPos]
    }
}

private fun String.maxFiveCharsPerWord(): String {
    val listOfFives = this.groupByFiveLetters()
    return listOfFives.joinToString(" ")
}

private fun String.groupByFiveLetters(): List<String> {
    val workingList = this.toMutableList()
    val outputList = mutableListOf<List<Char>>()
    while (workingList.size > 0) {
        outputList.add(workingList.take(5))
        (0..4).map { workingList.removeFirstLetterIfPresent() }
    }
    return outputList.map { it.joinToString("") }
}

private fun MutableList<Char>.removeFirstLetterIfPresent() {
    if (this.size > 0) {
        this.removeAt(0)
    }
}
