class Matrix(data: MatrixData, val saddlePoints: Set<MatrixCoordinate> = data.calculateSaddlePoints())

fun MatrixData.calculateSaddlePoints(): Set<MatrixCoordinate> {
    val firstRow = this[0]
    val firstColumn = this.let {
        when {
            firstRow.isNotEmpty() -> this.map { it[0] }
            else                  -> emptyList()
        }
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
        enhancedCoord.value >= enhancedCoord.row.filter { it != enhancedCoord.value }.sorted().last() &&
        enhancedCoord.value <= enhancedCoord.col.filter { it != enhancedCoord.value }.sorted().last()
    }.map { it.matrixCoordinate }.toSet()
}

typealias MatrixData = List<List<Int>>
data class MatrixCoordinate(val row: Int, val col: Int)
data class EnhancedCoordinate(val matrixCoordinate: MatrixCoordinate, val value: Int, val row: List<Int>, val col: List<Int>)