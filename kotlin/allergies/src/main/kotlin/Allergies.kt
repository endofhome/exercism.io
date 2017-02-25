class Allergies(val allergyType: Int) {
    fun isAllergicTo(allergen: Allergen): Boolean {
        return getList().any { it.score == allergen.score }
    }

    fun getList(): List<Allergen> {
        return Allergen.values().toList()
                .filter { it.score <= allergyType }
    }
}