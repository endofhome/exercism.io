object BracketPush {
    var openBrackets: MutableList<Char> = mutableListOf()
    private val squareBrackets = Bracket(openingValue = '[', closingValue = ']')
    private val braces = Bracket(openingValue = '{', closingValue = '}')
    private val parentheses = Bracket(openingValue = '(', closingValue = ')')

    class Bracket(val openingValue: Char = '[',
                  val closingValue: Char = ']',
                  var open: Int = 0
    ) {
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
                    squareBrackets.openingValue -> squareBrackets.openBracket()
                    squareBrackets.closingValue -> squareBrackets.closeBracket()
                    braces.openingValue         -> braces.openBracket()
                    braces.closingValue         -> braces.closeBracket()
                    parentheses.openingValue    -> parentheses.openBracket()
                    parentheses.closingValue    -> parentheses.closeBracket()
                }
            }
        } catch (e: IllegalStateException) {
            return false
        }

        return (squareBrackets.open == 0) && (braces.open == 0) && (parentheses.open == 0)
    }

    private fun resetState() {
        squareBrackets.reset()
        braces.reset()
        parentheses.reset()
    }
}
