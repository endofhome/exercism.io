object Pangrams {
    fun isPangram(sentence : String): Boolean {
        return ('a'..'z').all {
            sentence.contains(it, ignoreCase = true)
        }
    }
}