class School {
    private var db: MutableMap<Int, List<String>> = mutableMapOf()

    fun db() = db

    fun add(name: String, grade: Int) {
        db[grade] = mutableListOf(name)
    }

    fun grade(i: Int): List<String> = listOf()

    fun sort(): Map<Int, List<String>> = mapOf()
}