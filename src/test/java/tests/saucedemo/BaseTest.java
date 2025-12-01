package tests.saucedemo;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.saucedemo.CartPage;
import pages.saucedemo.LoginPage;
import pages.saucedemo.ProductPage;
import utils.TestListener;
import utils.WebDriverFactory;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        driver = WebDriverFactory.createDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        context.setAttribute("driver", driver);

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
