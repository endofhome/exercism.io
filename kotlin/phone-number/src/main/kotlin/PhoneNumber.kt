class PhoneNumber(unformattedNumber: String) {
    val number = unformattedNumber.filter(Char::isDigit)
    val areaCode: String? = null
}