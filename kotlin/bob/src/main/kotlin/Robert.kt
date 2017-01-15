object Bob {
    fun hey(input: String): String {
        return if (input == input.toUpperCase()) {
            "Whoa, chill out!"
        } else {
            "Whatever."
        }
    }
}