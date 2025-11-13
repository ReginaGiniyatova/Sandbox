package tests.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.saucedemo.LoginPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--guest");
        opt.addArguments("--start-maximized");

        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver, Duration.of(5000, ChronoUnit.MILLIS));

        loginPage = new LoginPage(driver, wait);
    }

    @AfterMethod
    public void quit() {
        if(driver != null)
            driver.quit();
    };
}
