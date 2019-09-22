package storage;

import com.opencsv.CSVReader;
import common.Alcoholic;
import org.telegram.telegrambots.meta.api.objects.Message;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class CSVStorage implements Storage {

    private File chatIds;
    private File messages;
    private File alcoholics;

    public CSVStorage() {
        chatIds = new File("chatids.csv");
        messages = new File("messages.csv");
        alcoholics = new File("alcoholics.csv");
    }
    @Override
    public HashSet<Long> getChatIds() {
        FileReader inputFile = new FileReader(chatIds);
        CSVReader reader = new CSVReader(inputFile);
        List<String[]> records = reader.readAll();
    }

    @Override
    public void removeId(Long chatId) {
        chatIds.remove(chatId);
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

    @Override
    public void cleanMessages() {
        messages.clear();
    }

    @Override
    public void addAlcoholic(Alcoholic alcoholic) {
        alcoholics.add(alcoholic);
    }

    @Override
    public ArrayList<Alcoholic> getAlcoholics() {
        return alcoholics;
    }
}
