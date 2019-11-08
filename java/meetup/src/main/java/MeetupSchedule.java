public enum MeetupSchedule {
    FIRST(1),
    SECOND(8),
    THIRD(15),
    FOURTH(22),
    LAST(null),
    TEENTH(13);

    private final Integer firstDayOfWeek;

    MeetupSchedule(Integer day) {
        firstDayOfWeek = day;
    }

    public Integer firstDayOfWeek() {
        return firstDayOfWeek;
    }
}
