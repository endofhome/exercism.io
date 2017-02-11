object Raindrops {
    fun convert(input: Int): String {
        var result = ""
        if (input % 3 == 0) result += "Pling"
        if (input % 5 == 0) result += "Plang"
        if (input % 7 == 0) result += "Plong"
        if (result == "") return input.toString()
        return result
    }
}