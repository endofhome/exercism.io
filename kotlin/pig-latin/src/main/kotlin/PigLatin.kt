object PigLatin {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val consonants = ('a'..'z').filterNot { it in vowels }
    val specialPairs = listOf("ch", "qu")

    fun translate(input: String): String = when {
        input.first() in vowels         -> input + "ay"
        input.take(2) in specialPairs -> input.drop(2) + input.subSequence(0, 2) + "ay"
        input.first() in consonants     -> input.drop(1) + input.first() + "ay"
        else          -> input
    }
}