import org.joda.time.DateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAccessor;
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
        int monthDay = IntStream.range(13, 20)
                .filter(i -> isTeenth(dayNumber, yearMonth, i))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Could not find teenth"));

        LocalDate meetupDate = yearMonth.atDay(monthDay);
        int year = meetupDate.getYear();
        int month = meetupDate.getMonthValue();
        int dayOfMonth = meetupDate.getDayOfMonth();

        return new DateTime(year, month, dayOfMonth, 0, 0);
    }

    private boolean isTeenth(int dayNumber, YearMonth yearMonth, int i) {
        return yearMonth.atDay(i).getDayOfWeek() == DayOfWeek.of(dayNumber);
    }
}
