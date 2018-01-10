object PigLatin {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val consonants = ('a'..'z').filterNot { it in vowels }

    fun translate(input: String): String = when (input.first()) {
            in vowels -> input + "ay"
            in consonants -> input.drop(1) + input.first() + "ay"
            else       -> input
    }
}