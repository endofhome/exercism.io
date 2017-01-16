object Bob {
    fun hey(input: String): String =
            when {
                input.isShouting() -> "Whoa, chill out!"
                input.endsWith("?") -> "Sure."
                input.isBlank() -> "Fine. Be that way!"
                else -> "Whatever."
            }

    private fun String.isShouting(): Boolean {
        return (this.contains(Regex("[A-Z]")) && this == this.toUpperCase())
    }
}