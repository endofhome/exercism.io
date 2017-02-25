class Allergies(val allergyType: Int) {
    fun isAllergicTo(allergen: Allergen): Boolean {
        return getList().any { it.score == allergen.score }
    }

    fun getList(): List<Allergen> {
        var remainder = allergyType
        val allergenList: MutableList<Allergen> = mutableListOf()
        for (allergen in Allergen.values().reversed()) {
            if (remainder >= allergen.score) {
                remainder -= allergen.score
                allergenList.add(allergen)
            }
        }
        return allergenList
    }
}