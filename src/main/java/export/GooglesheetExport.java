package export;

import storage.Storage;

import java.util.Date;

public class GooglesheetExport implements Export {

    private Storage storage;

    public GooglesheetExport(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void export() {

        String now = new Date().toString();

        storage.getAlcoholics().forEach(alcoholic -> {
            System.out.println(now + ";" + alcoholic.toString());
        });

    }
}
