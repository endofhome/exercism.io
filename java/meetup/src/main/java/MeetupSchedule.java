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
}
