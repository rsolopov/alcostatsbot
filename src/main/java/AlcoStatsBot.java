import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import storage.Storage;

public class AlcoStatsBot extends TelegramLongPollingBot {

    public AlcoStatsBot(Storage storage) {
        this.storage = storage;
    }

    private Storage storage;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            Long chatId = update.getMessage().getChatId();
            storage.saveId(chatId);
        } else if (update.hasCallbackQuery()) {

            String callData = update.getCallbackQuery().getData();
            Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();

            Alcoholic alcohlic = (Alcoholic) update.getMessage().getFrom();

            SendMessage message = new SendMessage().setChatId(chatId);

            if (callData.equals("yep")) {
                message.setText("Oh, you actually have. See you next time.");
                alcohlic.setDrinksToday(true);
            } else if (callData.equals("nah")) {
                message.setText("No? Ok. See you next time.");
                alcohlic.setDrinksToday(false);
            }

            var deleteMessage = new DeleteMessage().setChatId(chatId).setMessageId(messageId);

            try {
                execute(message);
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return Config.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Config.BOT_TOKEN;
    }


}
