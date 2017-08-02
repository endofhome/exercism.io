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
                        true -> {
                            val charPos = alphabet.indexOf(it.toLowerCase())
                            alphabet.reversed()[charPos]
                        }
                        false -> it
                    }
                }.toList().joinToString("")
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
        (0..4).map {
            if (workingList.size > 0) {
                workingList.removeAt(0)
            }
        }
    }
    return outputList.map { it.joinToString("") }
}
