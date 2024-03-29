package common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;

public class Config {

    public static final String BOT_TOKEN = System.getenv("ALCOBOT_TOKEN");
    public static final String BOT_NAME = "AlcoStatsBot";

    public static final int POLL_HOUR = 10;
    public static final int POLL_MINUTE = 0;

    public static final int DELETE_HOUR = 19;
    public static final int DELETE_MINUTE = 0;

    public static final int EXPORT_HOUR = 19;
    public static final int EXPORT_MINUTE = 10;

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
