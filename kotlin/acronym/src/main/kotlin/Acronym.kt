object Acronym {
    fun generate(phrase: String): String {
        return phrase
                .splitCamelCaseWords()
                .replaceHyphensWithWhitespace()
                .split(' ')
                .map {
                    it.first().toUpperCase()
                }.joinToString("")
    }

    private fun String.splitCamelCaseWords() =
            this.replace(Regex("(?<=[a-z])(?=[A-Z][a-z])"), " ")

    private fun String.replaceHyphensWithWhitespace() =
            this.replace("-", " ")
}
