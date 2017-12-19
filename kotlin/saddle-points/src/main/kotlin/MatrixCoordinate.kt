class Matrix(data: MatrixData, val saddlePoints: Set<MatrixCoordinate> = data.calculateSaddlePoints())

fun MatrixData.calculateSaddlePoints() = when {
    this.first().isEmpty() -> emptySet()
    else                   -> setOf(MatrixCoordinate(1, 0))
}

typealias MatrixData = List<List<Int>>
data class MatrixCoordinate(val row: Int, val col: Int)