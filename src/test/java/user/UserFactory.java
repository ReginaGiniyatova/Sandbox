package user;

import utils.PropertyReader;

public class UserFactory {

    public static User create(USER_TYPES type) {
        switch (type) {
            case ERROR: return new User(
                    PropertyReader.getProperty("saucedemo.login.error"),
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
            case VISUAL: return new User(
                    PropertyReader.getProperty("saucedemo.login.visual"),
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
            case PERFORMANCE_GLITCH: return new User(
                    PropertyReader.getProperty("saucedemo.login.performance"),
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
            case PROBLEM: return new User(
                    PropertyReader.getProperty("saucedemo.login.problem"),
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
            case LOCKED: return new User(
                    PropertyReader.getProperty("saucedemo.login.locked"),
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
            case LOGIN_BLANK: return new User(
                    "",
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
            case PASSWORD_BLANK: return new User(
                    PropertyReader.getProperty("saucedemo.login.standard"),
                    "",
                    type);
            case INCORRECT: return new User(
                    PropertyReader.getProperty("saucedemo.login.custom"),
                    PropertyReader.getProperty("saucedemo.password.custom"),
                    type);
            default:
            case STANDARD: return new User(
                    PropertyReader.getProperty("saucedemo.login.standard"),
                    PropertyReader.getProperty("saucedemo.password"),
                    type);
        }
    }
}
