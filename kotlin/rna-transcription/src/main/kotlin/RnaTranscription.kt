object RnaTranscription {

    fun ofDna(dnaString: String): String? {
        return dnaString.map {
            when (it) {
                'G' -> 'C'
                'C' -> 'G'
                'T' -> 'A'
                'A' -> 'U'
                else -> throw IllegalArgumentException("Invalid DNA input")
            }
        }.joinToString("")
    }
}