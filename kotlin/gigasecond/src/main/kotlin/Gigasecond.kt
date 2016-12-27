import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Gigasecond(inputDateTime : LocalDateTime) {
    val date: LocalDateTime = inputDateTime.plusSeconds(1000000000)

    constructor(inputDate: LocalDate) : this(LocalDateTime.of(inputDate, LocalTime.MIDNIGHT))
}