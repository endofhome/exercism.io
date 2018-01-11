object PigLatin {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val consonants = ('a'..'z').filterNot { it in vowels }
    val specialConsonantPairs = listOf("ch", "qu", "th", "rh")
    val specialConsonantTriples = listOf("thr", "sch")
    val specialVowelPairs = listOf("yt", "xr")

    fun translate(input: String) =
            input.split(" ")
                 .map { translateSingleWord(it) }
                 .joinToString(" ")

    fun translateSingleWord(word: String): String {
        val pigLatinEnding = "ay"

        return when {
            word.take(2) in specialVowelPairs       -> word + pigLatinEnding
            word.first() in vowels                  -> word + pigLatinEnding
            word.drop(1).take(2) == "qu"            -> word.drop(3) + word.take(3) + pigLatinEnding
            word.take(3) in specialConsonantTriples -> word.drop(3) + word.subSequence(0, 3) + pigLatinEnding
            word.take(2) in specialConsonantPairs   -> word.drop(2) + word.subSequence(0, 2) + pigLatinEnding
            word.first() in consonants              -> word.drop(1) + word.first() + pigLatinEnding
            else                                    -> word
        }
    }
}