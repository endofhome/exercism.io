class Matrix(data: MatrixData, val saddlePoints: Set<MatrixCoordinate> = data.calculateSaddlePoints())

fun MatrixData.calculateSaddlePoints(): Set<MatrixCoordinate> {
    val firstRow = this[0]
    val firstColumn = when {
        firstRow.isNotEmpty() -> this.map { this[0] }
        else                  -> emptyList()
    }

    val enhancedCoords = (0 until firstColumn.size).flatMap { heightPos ->
        (0 until firstRow.size).map { widthPos ->
            EnhancedCoordinate(
                MatrixCoordinate(widthPos, heightPos),
                this[widthPos][heightPos],
                this[widthPos],
                this.map { it[heightPos] }
            )
        }
    }

    return enhancedCoords.filter { enhancedCoord ->
        val thisRowPosition = enhancedCoord.matrixCoordinate.row
        val thisColPosition = enhancedCoord.matrixCoordinate.col
        enhancedCoord.value >= enhancedCoord.row.without(thisColPosition).sorted().last() &&
        enhancedCoord.value <= enhancedCoord.col.without(thisRowPosition).sorted().first()
    }.map { it.matrixCoordinate }.toSet()
}

private fun List<Int>.without(itemIndex: Int): List<Int> {
    return this.filterIndexed { index, _ -> index != itemIndex }
}

typealias MatrixData = List<List<Int>>
data class MatrixCoordinate(val row: Int, val col: Int)
data class EnhancedCoordinate(val matrixCoordinate: MatrixCoordinate, val value: Int, val row: List<Int>, val col: List<Int>)