object Accumulate {
    fun <T, B>accumulate(input: List<T>, transform: (T) -> B): List<B> {
        return input.map {
             transform(it)
        }
    }
}