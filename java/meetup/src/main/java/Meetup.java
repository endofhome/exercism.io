import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year  = year;
    }

    public DateTime day(int dayOfWeek, MeetupSchedule iteration) {
        List<DateTime> teens = new ArrayList<>();
        DateTime result = new DateTime();
        for (int i = 0; i < 7; i++) {
            teens.add(new DateTime(year, month, 13 + i, 0, 0));
        }
        for (DateTime teen : teens) {
            if (teen.dayOfWeek().get() == dayOfWeek) {
                result = teen;
            }
        }
        return result;
    }
}
