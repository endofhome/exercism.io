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

        int monthDay = range(schedule, yearMonth)
                .filter(i -> isMonthDay(dayNumber, yearMonth, i))
                .skip(accordingTo(schedule))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Could not find relevant day"));

        LocalDate meetupDate = yearMonth.atDay(monthDay);
        int year = meetupDate.getYear();
        int month = meetupDate.getMonthValue();
        int dayOfMonth = meetupDate.getDayOfMonth();

        return new DateTime(year, month, dayOfMonth, 0, 0);
    }

    private int accordingTo(MeetupSchedule schedule) {
        int numberToSkip;
        if (schedule == MeetupSchedule.SECOND) {
            numberToSkip = 1;
        } else if (schedule == MeetupSchedule.THIRD) {
            numberToSkip = 2;
        } else {
            numberToSkip = 0;
        }

        return numberToSkip;
    }

    private IntStream range(MeetupSchedule schedule, YearMonth yearMonth) {
        IntStream teenthRange = IntStream.range(13, 20);
        IntStream monthRange = IntStream.range(1, yearMonth.lengthOfMonth());

        IntStream range;
        if (schedule == MeetupSchedule.TEENTH) {
            range = teenthRange;
        } else {
            range = monthRange;
        }
        return range;
    }

    private boolean isMonthDay(int dayNumber, YearMonth yearMonth, int i) {
        return yearMonth.atDay(i).getDayOfWeek() == DayOfWeek.of(dayNumber);
    }
}
