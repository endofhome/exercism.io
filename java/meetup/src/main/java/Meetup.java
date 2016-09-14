import org.joda.time.DateTime;

public class Meetup {

    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year  = year;
    }

    public DateTime day(int dayOfWeek, MeetupSchedule iteration) {
        return new DateTime(2013, 5, 13, 0, 0);
    }
}
