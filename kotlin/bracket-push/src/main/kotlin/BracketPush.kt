import Brackets.SquareBrackets
import Brackets.Braces
import Brackets.Parentheses

object BracketPush {
    private val bracketTypes: List<Brackets> = listOf(SquareBrackets, Braces, Parentheses)
    private var openBrackets: MutableList<Char> = mutableListOf()

    fun isValid(input: String): Boolean {
        resetState()

        try {
            input.forEach { char -> findBracketTypeFor(char)?.process(char) }
        } catch (e: IllegalStateException) {
            return false
        }

        return bracketTypes.all { it.open() == 0 }
    }

    fun lastOpenBracket() = openBrackets.last()

    fun addOpenBracket(char: Char) = openBrackets.add(char)

    fun removeLastOpenBracket() = openBrackets.removeAt(openBrackets.lastIndex)

    private fun findBracketTypeFor(char: Char): Brackets? {
        val openingValues = bracketTypes.associateBy { it.openingValue }
        val closingValues = bracketTypes.associateBy { it.closingValue }
        val bracketCharacters = openingValues + closingValues
        return bracketCharacters[char]
    }

    private fun resetState() {
        bracketTypes.forEach { it.reset() }
    }
}

sealed class Brackets(
        val openingValue: Char,
        val closingValue: Char,
        private var open: Int = 0,
        private val bracketPush: BracketPush = BracketPush
) {
    object SquareBrackets : Brackets(openingValue = '[', closingValue = ']')
    object Braces : Brackets(openingValue = '{', closingValue = '}')
    object Parentheses : Brackets(openingValue = '(', closingValue = ')')

    fun reset() {
        open = 0
    }

    fun process(char: Char) {
        when (char) {
            openingValue -> openBracket()
            closingValue -> closeBracket()
        }
    }

    fun open() = open

    private fun openBracket() {
        open++
        bracketPush.addOpenBracket(openingValue)
    }

    private fun closeBracket() {
        if (bracketPush.lastOpenBracket() == openingValue) {
            open--
            bracketPush.removeLastOpenBracket()
        } else {
            throw IllegalStateException("Brackets are not nested correctly")
        }
        if (open < 0) {
            throw IllegalStateException("Cannot close brackets before they have been opened.")
        }
    }
}