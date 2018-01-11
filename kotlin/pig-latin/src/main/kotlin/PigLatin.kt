object PigLatin {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val consonants = ('a'..'z').filterNot { it in vowels }
    val consonantPairs = listOf("ch", "qu", "th", "rh")
    val consonantTriples = listOf("thr", "sch")
    val vowelPairs = listOf("yt", "xr")

    fun translate(input: String) =
            input.split(" ")
                 .map { translateSingleWord(it) }
                 .joinToString(" ")

    fun translateSingleWord(word: String): String = when {
        word.take(2) in vowelPairs       -> word + "ay"
        word.first() in vowels           -> word + "ay"
        word.drop(1).take(2) == "qu"     -> word.drop(3) + word.take(3) + "ay"
        word.take(3) in consonantTriples -> word.drop(3) + word.subSequence(0, 3) + "ay"
        word.take(2) in consonantPairs   -> word.drop(2) + word.subSequence(0, 2) + "ay"
        word.first() in consonants       -> word.drop(1) + word.first() + "ay"
        else          -> word
    }
}