class School {
    private var db: Map<Int, List<String>> = emptyMap()

    fun db() = db

    fun add(studentName: String, studentGrade: Int) {
        db += studentGrade to (grade(studentGrade) + studentName)
    }

    fun grade(grade: Int): List<String> {
        return db.get(grade).orEmpty()
    }

    fun sort(): Map<Int, List<String>> {
        return db.toSortedMap().mapValues { it.value.sorted() }
    }
}