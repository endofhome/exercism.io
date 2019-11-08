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
        Integer firstDayOfWeek = firstDayOfWeek(schedule, yearMonth);

        IntStream possibleRange;
        if (schedule == MeetupSchedule.TEENTH) {
            possibleRange = IntStream.range(13, 20);
        } else {
            possibleRange = IntStream.range(firstDayOfWeek, firstDayOfWeek + 7);
        }

        return possibleRange;
    }

    private Integer firstDayOfWeek(MeetupSchedule schedule, YearMonth yearMonth) {
        Integer firstDayOfWeek;
        if (schedule == MeetupSchedule.LAST) {
            firstDayOfWeek = schedule.calculateLastSevenDays(yearMonth.getMonthValue());
        } else {
            firstDayOfWeek = schedule.startingDay();
        }
        return firstDayOfWeek;
    }

    private boolean isMonthDay(int dayNumber, YearMonth yearMonth, int i) {
        return yearMonth.atDay(i).getDayOfWeek() == DayOfWeek.of(dayNumber);
    }
}
