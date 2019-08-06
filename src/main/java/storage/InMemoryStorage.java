package storage;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.HashSet;

public class InMemoryStorage implements Storage {

    private HashSet<Long> chatIds;
    private ArrayList<Message> messages;

    public InMemoryStorage() {

        chatIds = new HashSet<>();
        messages = new ArrayList<>();
    }

    @Override
    public HashSet<Long> getChatIds() {
        return chatIds;
    }

    @Override
    public void saveId(Long chatId) {
        chatIds.add(chatId);
    }

    @Override
    public void saveMessage(Message message) {
        messages.add(message);
    }

    @Override
    public ArrayList<Message> getMessages() {
        return messages;
    }
}
