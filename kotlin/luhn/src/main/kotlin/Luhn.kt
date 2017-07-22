object Luhn {
    fun isValid(numString: String): Boolean {
        return numString.length > 1
                && numString.noLettersOrPunctuation()
                && numString.replace(" ", "").everySecondValid()
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
    val oddCharList = oddChars()
        .map { Integer.parseInt(it.toString()) * 2 }
        .map {
            when (it > 9) {
                true -> it - 9
                false -> it
            }
        }
    val listWithDoubledOdds = oddCharList + evenChars().map { Integer.parseInt(it.toString()) }
    return listWithDoubledOdds.sum() % 10 == 0
}

private fun String.evenChars() = this.toList().reversed()
        .filterIndexed { i, _ -> i % 2 == 0 }

private fun String.oddChars() = this.toList().reversed()
        .filterIndexed { i, _ -> i % 2 != 0 }
