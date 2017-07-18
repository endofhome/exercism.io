enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    return when (naturalNumber.factors().sum() > naturalNumber) {
        true -> Classification.ABUNDANT
        false -> Classification.PERFECT
    }
}

fun Int.factors(): List<Int> {
    return (1..this).mapNotNull {
        when (this % it == 0 && this != it) {
          true -> it
          false -> null
        }
    }.toList()
}
