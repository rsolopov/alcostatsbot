package common;

import export.ConsoleExport;
import export.Export;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.telegram.telegrambots.meta.logging.BotLogger;
import org.telegram.telegrambots.meta.logging.BotsFileHandler;
import storage.InMemoryStorage;
import storage.Storage;
import tasks.DeleteUnprocessedMessageTimerTask;
import tasks.EverydayPollTimerTask;
import tasks.ExportTimerTask;
import tasks.Tasks;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {

        BotLogger.setLevel(Level.ALL);
        BotLogger.registerLogger(new ConsoleHandler());
        try {
            BotLogger.registerLogger(new BotsFileHandler());
        } catch (IOException e) {
            BotLogger.severe("Main", e);
        }

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        Storage storage = new InMemoryStorage();
        AlcoStatsBot alcobot = new AlcoStatsBot(storage);
        Export export = new ConsoleExport(storage);

        try {
            telegramBotsApi.registerBot(alcobot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        TimerTask everydayPollTask = new EverydayPollTimerTask(alcobot, storage);
        TimerTask deleteMessageTask = new DeleteUnprocessedMessageTimerTask(alcobot, storage);
        TimerTask exportTask = new ExportTimerTask(export);
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(everydayPollTask, Tasks.getStartDateFor(Config.POLL_HOUR, Config.POLL_MINUTE), Tasks.getPeriod());
        timer.scheduleAtFixedRate(deleteMessageTask, Tasks.getStartDateFor(Config.DELETE_HOUR, Config.DELETE_MINUTE), Tasks.getPeriod());
        timer.scheduleAtFixedRate(exportTask, Tasks.getStartDateFor(Config.EXPORT_HOUR, Config.EXPORT_MINUTE), Tasks.getPeriod());

    }
}
