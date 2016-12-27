object HelloWorld {
    fun hello(name: String?): String {
        val processedName = if (name.isNullOrBlank()) "World" else name
        return "Hello, $processedName!"
    }

    fun hello(): String {
        return hello("World")
    }
}