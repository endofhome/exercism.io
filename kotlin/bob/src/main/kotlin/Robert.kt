object Bob {
    fun hey(input: String): String {
        return if (input.endsWith("?")) {
           "Sure."
        } else if (input == input.toUpperCase()) {
            "Whoa, chill out!"
        } else {
            "Whatever."
        }
    }
}