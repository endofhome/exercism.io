object HelloWorld {
    fun hello(input: String?): String {
        val strippedName = stripNullOrBlank(input)
        val processedName = when (strippedName) {
            null -> "World"
            else -> strippedName
        }
        return "Hello, $processedName!"
    }

    fun hello(): String {
        return hello("World")
    }

    private fun stripNullOrBlank(input: String?): String? {
        if (input.isNullOrBlank()) return null
        return input
    }
}