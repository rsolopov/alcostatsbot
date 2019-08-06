package export;

import storage.Storage;

public class ConsoleExport implements Export {

    private Storage storage;

    public ConsoleExport(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void export() {

    }
}
