class Allergies(val allergyType: Int) {
    fun isAllergicTo(allergen: Allergen): Boolean {
        return getList().any { it.score == allergen.score }
    }

    fun getList(): List<Allergen> {
        val allergenList: MutableList<Allergen> = mutableListOf()
        val missingScores: MutableList<Int> = findMissingScores()
        var remainder = allergyType - missingScores.sum()

        for (allergen in Allergen.values().reversed()) {
            if (remainder >= allergen.score) {
                remainder -= allergen.score
                allergenList.add(allergen)
            }
        }

        return allergenList.reversed()
    }

    private fun findMissingScores(): MutableList<Int> {
        var currentMissingScore = Allergen.values().last().score * 2
        val missingScores: MutableList<Int> = mutableListOf()
        while (currentMissingScore <= allergyType) {
            missingScores.add(currentMissingScore)
            currentMissingScore *= 2
        }
        return missingScores
    }
}
