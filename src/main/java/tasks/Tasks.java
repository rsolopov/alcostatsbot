package tasks;

import java.time.LocalDateTime;

public class Tasks {


    public static Long getDelayFor(int hour) {
        LocalDateTime ldt = LocalDateTime.now();
        var currentHours = ldt.getHour();
        var currentMinutes = ldt.getMinute();
        var currentSeconds = ldt.getSecond();

        var totalDaySeconds = 24 * 60 * 60;
        var secondsToMidnight = totalDaySeconds -  ((currentHours * 60 * 60) + (currentMinutes * 60) + (60 - currentSeconds));
        var secondsFromMidnightToNineAm = hour * 60 * 60;
        var millisecondsToDelay = (secondsToMidnight + secondsFromMidnightToNineAm) * 1000;

        return (long) millisecondsToDelay;
    }


    public static Long getPeriod() {

        return 1000L * 60L * 60L * 24L;
    }

}
