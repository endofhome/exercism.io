object RomanNumeral {
    fun value(input: Int): String {
        return 1.rangeTo(input).map {
            "I"
        }.joinToString("")
    }
}