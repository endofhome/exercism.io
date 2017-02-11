class Allergies(val allergyType: Int) {
    fun isAllergicTo(allergen: Allergen): Boolean {
        return allergyType == allergen.score
    }

    fun getList(): List<Allergen> {
        return emptyList()
    }

}