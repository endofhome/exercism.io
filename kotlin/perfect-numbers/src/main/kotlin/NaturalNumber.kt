enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber >= 0)
    return when {
        naturalNumber.factors().sum() > naturalNumber -> Classification.ABUNDANT
        naturalNumber.factors().sum() < naturalNumber -> Classification.DEFICIENT
        else -> Classification.PERFECT
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
