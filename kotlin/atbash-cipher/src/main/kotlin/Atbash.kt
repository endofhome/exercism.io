object Atbash {
    val alphabet = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z')

    fun encode(input: String): String {
        return input.map {
            val charPos = alphabet.indexOf(it)
            alphabet.reversed()[charPos]
        }.toList().joinToString("")
    }

    fun decode(input: String): String {
        return ""
    }
}