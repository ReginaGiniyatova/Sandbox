package utils;

import org.testng.annotations.DataProvider;
import user.USER_TYPES;
import user.UserFactory;

import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {UserFactory.create(USER_TYPES.INCORRECT), PropertyReader.getProperty("saucedemo.messages.login_password_incorrect")},
                {UserFactory.create(USER_TYPES.LOGIN_BLANK), PropertyReader.getProperty("saucedemo.messages.login_required")},
                {UserFactory.create(USER_TYPES.PASSWORD_BLANK), PropertyReader.getProperty("saucedemo.messages.password_required")},
                {UserFactory.create(USER_TYPES.LOCKED), PropertyReader.getProperty("saucedemo.messages.locked_user")}
        };
    }

    @DataProvider(name = "productsData")
    public Object[][] productsData() {
        return new Object[][] {
                {List.of("Sauce Labs Backpack")},
                {List.of("Sauce Labs Bike Light", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket")},
                {List.of("Sauce Labs Bike Light", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie")}
        };
    }
}
