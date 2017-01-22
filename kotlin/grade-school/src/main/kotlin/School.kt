import java.util.HashMap

class School {
    private var db: Map<Int, List<String>> = emptyMap()

    fun db() = db

    fun add(name: String, grade: Int) {
        when (db.keys.contains(grade)) {
            true -> addStudentForExistingGrade(name, grade)
            false -> addStudentForNewGrade(name, grade)
        }
    }

    private fun addStudentForExistingGrade(name: String, grade: Int) {
        val localDb = db as MutableMap<Int, List<String>>
        val studentsForGrade: MutableList<String> = localDb.get(grade).orEmpty().toMutableList()
        studentsForGrade.add(name)
        localDb[grade] = studentsForGrade
        db = localDb
    }

    private fun addStudentForNewGrade(name: String, grade: Int) {
        val localDb: MutableMap<Int, List<String>> = HashMap(db)
        localDb[grade] = listOf(name)
        db = localDb
    }

    fun grade(grade: Int): List<String> {
        return db.get(grade).orEmpty()
    }

    fun sort(): Map<Int, List<String>> {
        return db.keys.sorted().map {
            it to db[it].orEmpty().sorted()
        }.toMap()
    }
}