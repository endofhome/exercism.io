object Bob {
    fun hey(input: String): String {
        return if (input.contains(Regex("[A-Z]")) && input == input.toUpperCase()) {
           "Whoa, chill out!"
        } else if (input.endsWith("?")) {
            "Sure."
        } else {
            "Whatever."
        }
    }
}