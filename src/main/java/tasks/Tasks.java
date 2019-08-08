package tasks;

import java.time.*;
import java.util.Date;

public class Tasks {

    public static Long getPeriod() {

        return 1000L * 60L * 60L * 24L;
    }

    public static Date getStartDateFor(int hour, int minute) {
        LocalDate tmrw = LocalDate.now().plusDays(1);
        LocalTime time = LocalTime.of(hour, minute);
        LocalDateTime startTime = LocalDateTime.of(tmrw, time);
        return Date.from(startTime.toInstant(ZoneOffset.UTC));
    }

}
