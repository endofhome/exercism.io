enum class Allergen(val score: Int) {
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128)
}

class Allergies(val allergyType: Int) {
    fun isAllergicTo(allergen: Allergen): Boolean {
        return when (allergyType) {
            0 -> false
            else -> true
        }
    }

    fun getList(): List<Allergen> {
        return listOf()
    }
}