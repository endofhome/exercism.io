class DiamondPrinter {
    fun printToList(char: Char): List<String>? {
        val topUnpadded = ('A'..char).mapIndexed { index, character ->
            when (index) {
                0    -> character.toString()
                else -> character + padWith((index * 2) -1) + character
             }
        }
        val width = topUnpadded.last().length
        val top = topUnpadded.map {
            val sidePadding = (width - it.length) / 2
            padWith(sidePadding) + it + padWith(sidePadding)
        }
        return reflectedDiamond(top)
    }

    private fun reflectedDiamond(top: List<String>): List<String> {
        return when {
            top.size == 1 -> top
            else          -> top + top.reversed().drop(1)
        }
    }

    private fun padWith(padding: Int) = (0 until padding).map { ' ' }.joinToString("")

}
