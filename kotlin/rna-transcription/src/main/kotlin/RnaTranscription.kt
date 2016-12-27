class RnaTranscription() {

    companion object Transcriber {
        val dnaToRna = mapOf(
                Pair("G", "C"),
                Pair("C", "G"),
                Pair("T", "A"),
                Pair("A", "U")
        )

        fun ofDna(dnaString : String): String? {
            val transcription = dnaString.map {
                char -> transformChar(char.toString())
            }
            return transcription.joinToString("")
        }

        private fun transformChar(dnaString: String): String? {
            if (dnaToRna[dnaString].isNullOrBlank()) {
                return ""
            }
            return dnaToRna[dnaString]
        }
    }
}