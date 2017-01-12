object Hamming {
    fun compute(base: String, compare: String): Int {
        if (base == compare) {
            return 0
        }
        return 1
    }
}