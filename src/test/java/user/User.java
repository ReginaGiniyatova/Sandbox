package user;

public class User {

    private String login;
    private String password;
    private USER_TYPES type;

    public User(String login, String password, USER_TYPES type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public USER_TYPES getType() {
        return type;
    }
}
