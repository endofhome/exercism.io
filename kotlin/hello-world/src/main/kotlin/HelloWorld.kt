object HelloWorld {
    fun hello(name: String? = "Default name"): String {
        val processedName = when (name) {
            "Default name" -> "World"
            null -> "World"
            "" -> "World"
            "    " -> "World"
            else -> name
        }
        return "Hello, $processedName!"
    }
}