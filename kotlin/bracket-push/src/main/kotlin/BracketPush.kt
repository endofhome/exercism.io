object BracketPush {
    object SquareBrackets {
        val openingValue = '['
        val closingValue = ']'
        var open = 0
    }

    fun isValid(input: String): Boolean {
        input.forEach { char ->
            when (char) {
                SquareBrackets.openingValue -> SquareBrackets.open++
                SquareBrackets.closingValue -> SquareBrackets.open--
            }
        }

        return SquareBrackets.open == 0
    }
}