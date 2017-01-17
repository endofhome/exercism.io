class Robot {
    var name = generateName()

    private fun generateName(): String {
        val letters = ('A'..'Z').toList()
        fun letter() = letters[(Math.random() * letters.size).toInt()].toString()

        val numbers = (0..9).toList()
        fun number() = numbers[(Math.random() * numbers.size).toInt()].toString()

        return letter() + letter() + number() + number() + number()
    }

    fun reset() {
        name = generateName()
    }
}