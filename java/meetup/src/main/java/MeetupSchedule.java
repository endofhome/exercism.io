import java.util.Arrays;

public enum MeetupSchedule {
    FIRST (1),
    SECOND (8),
    THIRD (15),
    FOURTH (22),
    LAST (null),
    TEENTH (13);

    private final Integer startingDay;

    MeetupSchedule(Integer day) {
        startingDay = day;
    }

    public Integer startingDay() {
        return startingDay;
    }

    public Integer calculateLastSevenDays(int month) {
        if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(month)) {
            return 25;
        } else if (Arrays.asList(4, 6, 9, 11).contains(month)) {
            return 24;
        } else {
            return 21;
        }
    }
}
