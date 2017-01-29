object Acronym {
    fun generate(phrase: String): String {
        return phrase.splitCamelCase().split(' ').map {
            it.first().toUpperCase()
        }.joinToString("")
    }


    fun String.splitCamelCase(): String {
        return this.replace(Regex("(?<=[a-z])(?=[A-Z][a-z])"), " ")
    }
}