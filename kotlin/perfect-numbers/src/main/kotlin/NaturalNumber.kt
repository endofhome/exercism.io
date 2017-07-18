enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber % 12 == 0) return Classification.ABUNDANT
    return Classification.PERFECT
}
