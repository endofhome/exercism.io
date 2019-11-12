import java.time.YearMonth;
import java.util.function.Function;

public enum MeetupSchedule {
    FIRST(x -> 1),
    SECOND(x -> 8),
    THIRD(x -> 15),
    FOURTH(x -> 22),
    LAST(yearMonth -> yearMonth.lengthOfMonth() - 6),
    TEENTH(x -> 13);

    private final Function<YearMonth, Integer> firstDayOfWeek;

    MeetupSchedule(Function<YearMonth, Integer> day) {
        firstDayOfWeek = day;
    }

    public Integer firstDayOfWeek(YearMonth yearMonth) {
        return firstDayOfWeek.apply(yearMonth);
    }
}
