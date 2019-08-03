package storage;

import java.util.HashSet;

public interface Storage {

    HashSet<Long> getChatIds();
    void saveId(Long chatId);

}
