import Brackets.SquareBrackets
import Brackets.Braces
import Brackets.Parentheses

object BracketPush {
    private val bracketTypes: List<Brackets> = listOf(SquareBrackets, Braces, Parentheses)
    private var openBrackets: MutableList<Char> = mutableListOf()

    fun isValid(input: String): Boolean {
        resetState()

        try {
            input.forEach { char ->
                val maybeBracket: Brackets? = analysed(char)
                when (maybeBracket) {
                    is Brackets -> maybeBracket.process(char)
                }
            }
        } catch (e: IllegalStateException) {
            return false
        }

        return bracketTypes.all { it.open == 0 }
    }

    fun addOpenBracket(char: Char) = openBrackets.add(char)

    fun lastOpenBracket() = openBrackets.last()

    fun removeLastOpenBracket() = openBrackets.removeAt(openBrackets.lastIndex)


    private fun analysed(char: Char): Brackets? {
        val openingValues = BracketPush.bracketTypes.map { bracketType -> bracketType.openingValue to bracketType }
        val closingValues = BracketPush.bracketTypes.map { bracketType -> bracketType.closingValue to bracketType }
        val bracketCharacters = openingValues + closingValues
        return bracketCharacters.find { it.first == char }?.second
    }

    private fun resetState() {
        bracketTypes.forEach { it.reset() }
    }
}

sealed class Brackets(
        val openingValue: Char,
        val closingValue: Char,
        var open: Int = 0,
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