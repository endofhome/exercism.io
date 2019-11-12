import org.joda.time.DateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.stream.IntStream;

public class Meetup {
    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year  = year;
    }

    public DateTime day(int dayNumber, MeetupSchedule schedule) {
        YearMonth yearMonth = YearMonth.of(year, month);

        int monthDay = possibleDays(schedule, yearMonth)
                .filter(i -> isMonthDay(dayNumber, yearMonth, i))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Could not find relevant day"));

        LocalDate meetupDate = yearMonth.atDay(monthDay);

        return new DateTime(year, month, meetupDate.getDayOfMonth(), 0, 0);
    }

    private IntStream possibleDays(MeetupSchedule schedule, YearMonth yearMonth) {
        Integer firstDayOfWeek = schedule.firstDayOfWeek(yearMonth);

        return IntStream.range(firstDayOfWeek, firstDayOfWeek + 7);
    }

    private boolean isMonthDay(int dayNumber, YearMonth yearMonth, int i) {
        return yearMonth.atDay(i).getDayOfWeek() == DayOfWeek.of(dayNumber);
    }
}
