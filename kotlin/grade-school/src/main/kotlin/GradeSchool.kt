class School {
    private var db: MutableMap<Int, List<String>> = mutableMapOf()

    fun db() = db

    fun add(name: String, grade: Int) {
        var studentsForGrade: MutableList<String> = mutableListOf()
        if (db.keys.contains(grade)) {
            studentsForGrade = db.get(grade)!!.toMutableList()
        }
        studentsForGrade.add(name)
        db[grade] = studentsForGrade.toList()
    }

    fun grade(i: Int): List<String> = listOf()

    fun sort(): Map<Int, List<String>> {
        return db.keys.sorted().map {
            it to db[it].orEmpty().sorted()
        }.toMap()
    }
}