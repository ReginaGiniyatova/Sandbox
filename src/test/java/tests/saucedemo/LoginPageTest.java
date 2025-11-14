package tests.saucedemo;

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
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.hasProductTitle());
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login("marpha", "the_cat");
        assertFalse(productPage.hasProductTitle());
    }

    @Test
    public void emptyUsernameTest() {
        loginPage.login("", "secret_sauce");
        assertFalse(productPage.hasProductTitle());
    }

    @Test
    public void emptyPasswordTest() {
        loginPage.login("standard_user", "");
        assertFalse(productPage.hasProductTitle());
    }
}
