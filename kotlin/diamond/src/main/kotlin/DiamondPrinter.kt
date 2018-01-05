class DiamondPrinter {
    fun printToList(char: Char): List<String>? {
        val topUnpadded = ('A'..char).mapIndexed { index, character ->
            (0..index).map { character }.joinToString(" ")
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
            else          -> top + top.filterIndexed { index, _ -> index == 0 }
        }
    }

    private fun padWith(padding: Int) = (0 until padding).map { ' ' }.joinToString("")
}
