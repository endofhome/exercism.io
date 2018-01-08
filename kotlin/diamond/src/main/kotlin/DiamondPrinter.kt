class DiamondPrinter {
    fun printToList(char: Char): List<String>? {
        val topUnpadded = ('A'..char).mapIndexed { index, character ->
            when (index) {
                0 -> character.toString()
                else -> character + centrePadding(index) + character
            }

        }
        val width = topUnpadded.last().length
        val top = topUnpadded.map {
            val padding = (width - it.length) / 2
            padWith(padding) + it + padWith(padding)
        }
        return reflectedDiamond(top)
    }

    private fun reflectedDiamond(top: List<String>): List<String> {
        return when {
            top.size == 1 -> top
            else          -> top + top.reversed().filterIndexed { index, _ -> index != 0 }
        }
    }

    private fun padWith(padding: Int) = (0 until padding).map { ' ' }.joinToString("")

    private fun centrePadding(index: Int): String {
        return when (index) {
            1    -> padWith(index)
            else -> padWith(index + 1)
        }
    }
}
