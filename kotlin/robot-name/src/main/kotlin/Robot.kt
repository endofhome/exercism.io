class Robot {
    val letters = ('A'..'Z').toList()
    val numbers = (0..9).toList()
    var previousNames = mutableSetOf<String>()
    var name = generateName()

    private fun generateName(): String {
        val proposedName = letter() + letter() + number() + number() + number()

        if (previousNames.contains(proposedName)) {
            return generateName()
        }
        previousNames.add(proposedName)
        return proposedName
    }

    private fun letter() = letters[(Math.random() * letters.size).toInt()].toString()

    private fun number() = numbers[(Math.random() * numbers.size).toInt()].toString()

    fun reset() {
        name = generateName()
    }
}
