package tests.saucedemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPageTest extends BaseTest {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage.openPage();
    }

    @Test
    public void validLoginTest() {
        boolean isLoginSuccess = loginPage.login("standard_user", "secret_sauce");
        assertTrue(isLoginSuccess);
    }

    @Test
    public void invalidLoginTest() {
        boolean isLoginFailed = loginPage.login("marpha", "the_cat");
        assertFalse(isLoginFailed);
    }

    @Test
    public void emptyUsernameTest() {
        boolean isEmptyUsername = loginPage.login("", "secret_sauce");
        assertFalse(isEmptyUsername);
    }

    @Test
    public void emptyPasswordTest() {
        boolean isEmptyPassword = loginPage.login("standard_user", "");
        assertFalse(isEmptyPassword);
    }
}
