import java.time.YearMonth;
import java.util.function.Function;

public enum MeetupSchedule {
    FIRST(yearMonth -> 1),
    SECOND(yearMonth -> 8),
    THIRD(yearMonth -> 15),
    FOURTH(yearMonth -> 22),
    LAST(yearMonth -> yearMonth.lengthOfMonth() - 6),
    TEENTH(yearMonth -> 13);

    private final Function<YearMonth, Integer> firstDayOfWeek;

    MeetupSchedule(Function<YearMonth, Integer> firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public Integer firstDayOfWeek(YearMonth yearMonth) {
        return firstDayOfWeek.apply(yearMonth);
    }
}
