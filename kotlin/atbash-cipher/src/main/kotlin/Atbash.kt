object Atbash {
    val alphabet = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z')

    fun encode(input: String): String {
        return input.map {
            val charPos = alphabet.indexOf(it.toLowerCase())
            alphabet.reversed()[charPos]
        }.toList().joinToString("").maxFiveCharsPerWord()
    }

    fun decode(input: String): String {
        return ""
    }
}

private fun String.maxFiveCharsPerWord(): String {
    val listOfFives = this.listOfFives()
    return listOfFives.joinToString(" ")
}

private fun  String.listOfFives(): List<String> {
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
