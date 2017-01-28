object Acronym {
    fun generate(phrase: String): String {
        return phrase.split(' ').map {
            it.first().toUpperCase()
        }.joinToString("")
    }
}