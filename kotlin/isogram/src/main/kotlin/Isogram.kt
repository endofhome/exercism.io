class Isogram {
    companion object {
        fun isIsogram(input: String): Boolean {
            return input.toLowerCase()
                    .toList()
                    .filterNot {
                        it == '-' || it == ' '
                    }
                    .groupBy { it }
                    .mapValues { it.value.size }
                    .all { it.value == 1 }
        }
    }
}