package tests.saucedemo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.*;
import user.USER_TYPES;
import user.User;
import user.UserFactory;
import utils.PropertyReader;
import utils.TestDataProvider;

import static org.testng.AssertJUnit.*;

public class LoginPageTest extends BaseTest {
    @Parameters({"browser"})
    @BeforeMethod
    @Override
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        super.setUp(browser, context);
        loginPage.openPage();
    }

    @Epic("Модуль логина интернет-магазина")
    @Feature("Авторизация")
    @Test(description = "Тест на корректную авторизацию")
    @Owner("Giniyatova Regina")
    public void validLoginTest() {
        loginPage.login(UserFactory.create(USER_TYPES.STANDARD));
        assertTrue(productPage.hasProductTitle());
    }

    @Epic("Модуль логина интернет-магазина")
    @Feature("Авторизация")
    @Test(description = "Тест на некорректную авторизацию", dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    @Owner("Giniyatova Regina")
    public void invalidLoginTest(User user, String errorMsg) {
        loginPage.login(user);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
