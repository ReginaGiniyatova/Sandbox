package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.collections.Pair;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WebDriverFactory {

    public static Pair<WebDriver, WebDriverWait> createDriver(String browser) {
        WebDriver driver;
        WebDriverWait wait;

        switch (browser.toLowerCase()) {
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--guest");

                driver = new FirefoxDriver(options);
                wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

                break;
            }
            case "safari": {
                SafariOptions options = new SafariOptions();

                driver = new SafariDriver(options);
                wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

                break;
            }
            case "chrome":
            default: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--guest");

                driver = new ChromeDriver(options);
                wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

                break;
            }
        }

        return new Pair<>(driver, wait);
    }
}
