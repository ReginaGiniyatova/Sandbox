package tests.saucedemo;

import org.testng.annotations.*;
import user.USER_TYPES;
import user.User;
import user.UserFactory;
import utils.PropertyReader;

import static org.testng.AssertJUnit.*;

public class LoginPageTest extends BaseTest {
    @Parameters({"browser"})
    @BeforeMethod
    @Override
    public void setUp(@Optional("chrome") String browser) {
        super.setUp(browser);
        loginPage.openPage();
    }

    @Test
    public void validLoginTest() {
        loginPage.login(UserFactory.create(USER_TYPES.STANDARD));
        assertTrue(productPage.hasProductTitle());
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][] {
                {UserFactory.create(USER_TYPES.INCORRECT), PropertyReader.getProperty("saucedemo.messages.login_password_incorrect")},
                {UserFactory.create(USER_TYPES.LOGIN_BLANK), PropertyReader.getProperty("saucedemo.messages.login_required")},
                {UserFactory.create(USER_TYPES.PASSWORD_BLANK), PropertyReader.getProperty("saucedemo.messages.password_required")},
                {UserFactory.create(USER_TYPES.LOCKED), PropertyReader.getProperty("saucedemo.messages.locked_user")}
        };
    }

    @Test(dataProvider = "loginData")
    public void invalidLoginTest(User user, String errorMsg) {
        loginPage.login(user);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
