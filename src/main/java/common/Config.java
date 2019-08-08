package common;

public class Config {

    public static final String BOT_TOKEN = System.getenv("ALCOBOT_TOKEN");
    public static final String BOT_NAME = "AlcoStatsBot";

    public static final int POLL_HOUR = 10;
    public static final int POLL_MINUTE = 0;

    public static final int DELETE_HOUR = 19;
    public static final int DELETE_MINUTE = 0;

    public static final int EXPORT_HOUR = 19;
    public static final int EXPORT_MINUTE = 10;

}
