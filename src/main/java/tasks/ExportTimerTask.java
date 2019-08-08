package tasks;

import export.Export;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import storage.Storage;

import java.util.TimerTask;

public class ExportTimerTask extends TimerTask {

    private Export export;

    public ExportTimerTask(Export export) {
        this.export = export;
    }

    @Override
    public void run() {
        export.export();
    }
}
