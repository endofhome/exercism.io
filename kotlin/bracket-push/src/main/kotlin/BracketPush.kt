import BracketPush.Bracket.SquareBracket
import BracketPush.Bracket.Braces
import BracketPush.Bracket.Parentheses

object BracketPush {
    private val bracketTypes: List<Bracket> = listOf(SquareBracket, Braces, Parentheses)
    private var openBrackets: MutableList<Char> = mutableListOf()

    sealed class Bracket(
            val openingValue: Char,
            val closingValue: Char,
            var open: Int = 0
    ) {

        object SquareBracket : Bracket(openingValue = '[', closingValue = ']')
        object Braces : Bracket(openingValue = '{', closingValue = '}')
        object Parentheses : Bracket(openingValue = '(', closingValue = ')')

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

        fun process(char: Char) {
            when (char) {
                openingValue -> openBracket()
                closingValue -> closeBracket()
            }
        }
    }

    fun isValid(input: String): Boolean {
        resetState()

        try {
            input.forEach { char ->
                val maybeBracket: Bracket? = analysed(char)
                when (maybeBracket) {
                    is Bracket -> maybeBracket.process(char)
                }
            }
        } catch (e: IllegalStateException) {
            return false
        }

        return bracketTypes.all { it.open == 0 }
    }

    private fun analysed(char: Char): Bracket? {
        val openingValues = BracketPush.bracketTypes.map { bracketType -> bracketType.openingValue to bracketType }
        val closingValues = BracketPush.bracketTypes.map { bracketType -> bracketType.closingValue to bracketType }
        val bracketCharacters = openingValues + closingValues
        return bracketCharacters.find { it.first == char }?.second
    }

    private fun resetState() {
        bracketTypes.forEach { it.reset() }
    }
}
