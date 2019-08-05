package storage;

import java.util.HashSet;

public class InMemoryStorage implements Storage {

    private HashSet<Long> chatIds;

    public InMemoryStorage() {

        chatIds = new HashSet<>();
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
    public void savePollMessage(Long chatId, Integer messageId) {

    }
}
