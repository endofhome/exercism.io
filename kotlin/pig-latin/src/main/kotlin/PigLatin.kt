object PigLatin {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')

    fun translate(input: String): String {
        return when (input.first()) {
            in vowels -> input + "ay"
            else       -> input
        }
    }
}