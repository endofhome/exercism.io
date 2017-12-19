class Matrix(data: MatrixData, val saddlePoints: Set<MatrixCoordinate> = data.calculateSaddlePoints())

fun MatrixData.calculateSaddlePoints() = setOf(MatrixCoordinate(1, 0))

data class MatrixCoordinate(val row: Int, val col: Int)
typealias MatrixData = List<List<Int>>