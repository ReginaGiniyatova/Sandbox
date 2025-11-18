package tests.saucedemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

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

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {"marpha", "the_cat", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String name, String password, String errorMsg) {
        loginPage.login(name, password);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
