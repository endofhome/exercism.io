object Luhn {
    fun isValid(numString: String): Boolean {
        val noWhitespace = numString.replace(" ", "")
        return noWhitespace.length > 1
                && noWhitespace.noLettersOrPunctuation()
                && noWhitespace.everySecondValid()
    }
}

private fun  String.noLettersOrPunctuation(): Boolean {
    return when {
        this.contains(Regex("[a-zA-Z]")) -> false
        this.contains(Regex("[,.!?\\-]")) -> false
        this.contains(Regex("[@£$%^&*()_+={}<>]")) -> false
        else -> true
    }
}

private fun  String.everySecondValid(): Boolean {
    val odds = oddChars()
        .map { Integer.parseInt(it.toString()) * 2 }
        .map {
            when (it > 9) {
                true -> it - 9
                false -> it
            }
        }
    return (odds + evens()).sum() % 10 == 0
}

private fun String.evens() = this.toList().reversed()
        .filterIndexed { i, _ -> i % 2 == 0 }
        .map { Integer.parseInt(it.toString()) }

private fun String.oddChars() = this.toList().reversed()
        .filterIndexed { i, _ -> i % 2 != 0 }
