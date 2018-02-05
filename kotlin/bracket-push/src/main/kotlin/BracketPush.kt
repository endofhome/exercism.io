object BracketPush {
    object SquareBrackets {
        val openingValue = '['
        val closingValue = ']'
        var open = 0

        fun reset() {
            open = 0
        }
    }

    object Braces {
        val openingValue = '{'
        val closingValue = '}'
        var open = 0

        fun reset() {
            open = 0
        }
    }

    fun isValid(input: String): Boolean {
        resetCounts()

        input.forEach { char ->
            when (char) {
                SquareBrackets.openingValue -> SquareBrackets.open++
                SquareBrackets.closingValue -> SquareBrackets.open--
                Braces.openingValue         -> Braces.open++
                Braces.closingValue         -> Braces.open--
            }
        }

        return (SquareBrackets.open == 0) && (Braces.open == 0)
    }

    private fun resetCounts() {
        SquareBrackets.reset()
        Braces.reset()
    }
}