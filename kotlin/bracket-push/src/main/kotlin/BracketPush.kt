object BracketPush {
    var openBrackets: MutableList<Char> = mutableListOf()

    object SquareBrackets {
        val openingValue = '['
        val closingValue = ']'
        var open = 0

        fun reset() {
            open = 0
        }

        fun openBracket() {
            open++
            openBrackets.add(openingValue)
        }

        fun closeBracket() {
            if (openBrackets.last() == openingValue) {
                open--
                openBrackets.removeAt(openBrackets.lastIndex)
            } else {
                throw IllegalStateException("Brackets are not nested correctly")
            }
            if (open < 0) {
                throw IllegalStateException("Cannot close brackets before they have been opened.")
            }
        }
    }

    object Braces {
        val openingValue = '{'
        val closingValue = '}'
        var open = 0

        fun reset() {
            open = 0
        }

        fun openBracket() {
            open++
            openBrackets.add(openingValue)
        }

        fun closeBracket() {
            if (openBrackets.last() == openingValue) {
                open--
                openBrackets.removeAt(openBrackets.lastIndex)
            } else {
                throw IllegalStateException("Brackets are not nested correctly")
            }
            if (open < 0) {
                throw IllegalStateException("Cannot close brackets before they have been opened.")
            }
        }
    }

    object Parentheses {
        val openingValue = '('
        val closingValue = ')'
        var open = 0

        fun reset() {
            open = 0
        }

        fun openBracket() {
            open++
            openBrackets.add(openingValue)
        }

        fun closeBracket() {
            if (openBrackets.last() == openingValue) {
                open--
                openBrackets.removeAt(openBrackets.lastIndex)
            } else {
                throw IllegalStateException("Brackets are not nested correctly")
            }
            if (open < 0) {
                throw IllegalStateException("Cannot close brackets before they have been opened.")
            }
        }
    }

    fun isValid(input: String): Boolean {
        resetState()

        try {
            input.forEach { char ->
                when (char) {
                    SquareBrackets.openingValue -> SquareBrackets.openBracket()
                    SquareBrackets.closingValue -> SquareBrackets.closeBracket()
                    Braces.openingValue         -> Braces.openBracket()
                    Braces.closingValue         -> Braces.closeBracket()
                    Parentheses.openingValue    -> Parentheses.openBracket()
                    Parentheses.closingValue    -> Parentheses.closeBracket()
                }
            }
        } catch (e: IllegalStateException) {
            return false
        }

        return (SquareBrackets.open == 0) && (Braces.open == 0) && (Parentheses.open == 0)
    }

    private fun resetState() {
        SquareBrackets.reset()
        Braces.reset()
        Parentheses.reset()
    }
}