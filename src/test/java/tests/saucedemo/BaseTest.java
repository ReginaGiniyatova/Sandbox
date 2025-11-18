package tests.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.collections.Pair;
import pages.saucedemo.CartPage;
import pages.saucedemo.LoginPage;
import pages.saucedemo.ProductPage;
import utils.WebDriverFactory;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        Pair<WebDriver, WebDriverWait> driverPair = WebDriverFactory.createDriver(browser);

        driver = driverPair.first();
        wait = driverPair.second();

        loginPage = new LoginPage(driver, wait);
        productPage = new ProductPage(driver, wait);
        cartPage = new CartPage(driver, wait);
    }

    @AfterMethod
    public void quit() {
        if(driver != null)
            driver.quit();
    };
}
