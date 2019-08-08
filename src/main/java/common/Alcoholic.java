package common;

import org.telegram.telegrambots.meta.api.objects.User;

public class Alcoholic extends User {

    private boolean drunkToday;

    public boolean isDrunkToday() {
        return drunkToday;
    }

    public void setDrunkToday(boolean drunkToday) {
        this.drunkToday = drunkToday;
    }

    @Override
    public String toString() {

        return
                this.getId() + ";" +
                this.getUserName() +  ";" +
                this.isDrunkToday();
    }
}
