package tasks;

import export.Export;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import storage.Storage;

import java.util.TimerTask;

public class ExportTimerTask extends TimerTask {

    private TelegramLongPollingBot bot;
    private Storage storage;
    private Export export;

    public ExportTimerTask(TelegramLongPollingBot bot, Storage storage, Export export) {
        this.bot = bot;
        this.storage = storage;
        this.export = export;
    }

    @Override
    public void run() {

    }
}
