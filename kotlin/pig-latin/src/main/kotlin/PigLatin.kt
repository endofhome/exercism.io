object PigLatin {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val consonants = ('a'..'z').filterNot { it in vowels }
    val consonantPairs = listOf("ch", "qu", "th", "rh")
    val consonantTriples = listOf("thr", "sch")
    val vowelPairs = listOf("yt", "xr")

    fun translate(input: String): String = when {
        input.take(2) in vowelPairs       -> input + "ay"
        input.first() in vowels           -> input + "ay"
        input.drop(1).take(2) == "qu"     -> input.drop(3) + input.take(3) + "ay"
        input.take(3) in consonantTriples -> input.drop(3) + input.subSequence(0, 3) + "ay"
        input.take(2) in consonantPairs   -> input.drop(2) + input.subSequence(0, 2) + "ay"
        input.first() in consonants       -> input.drop(1) + input.first() + "ay"
        else          -> input
    }
}