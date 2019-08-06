import org.telegram.telegrambots.meta.api.objects.User;

public class Alcoholic extends User {

    private boolean drinksToday;

    public boolean isDrinksToday() {
        return drinksToday;
    }

    public void setDrinksToday(boolean drinksToday) {
        this.drinksToday = drinksToday;
    }
}
