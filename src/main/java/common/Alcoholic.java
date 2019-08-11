package common;

import org.telegram.telegrambots.meta.api.objects.User;

public class Alcoholic  {

    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private boolean drunkToday;

    public Alcoholic(User user) {

        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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
                        this.getUserName() + ";" +
                        this.isDrunkToday();
    }
}
