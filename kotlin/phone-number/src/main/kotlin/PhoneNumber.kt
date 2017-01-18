class PhoneNumber(unformattedNumber: String) {
    val number = validateNumber(unformattedNumber)
    val areaCode: String? = null

    private fun validateNumber(unformattedNumber: String): String {
        return unformattedNumber.removeFirstEntryIfOneAndLengthTen()
                .filter(Char::isDigit)
    }

    private fun String.removeFirstEntryIfOneAndLengthTen(): String {
        if (this.length == 11 && this.first() == '1') {
            return this.substring(1)
        }
        return this
    }
}