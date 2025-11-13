package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage {

    private final static String URL = "https://www.saucedemo.com/";
    private final static By USERNAME = new By.ByCssSelector("#user-name");
    private final static By PASSWORD = new By.ByCssSelector("#password");
    private final static By LOGIN_BTN = new By.ByCssSelector("#login-button");
    private final static By PRODUCT_TITLE = new By.ByCssSelector("span[data-test='title']");
    private final static By ERROR_MSG = new By.ByCssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean login(String username, String password) {
        WebElement usernameInput = driver.findElement(USERNAME);
        WebElement passwordInput = driver.findElement(PASSWORD);
        WebElement loginBtn = driver.findElement(LOGIN_BTN);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

        List<WebElement> error = driver.findElements(ERROR_MSG);
        if(!error.isEmpty()) return false;

        WebElement productTitle;

        try {
            productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
        } catch (TimeoutException e) {
            return false;
        }

        return productTitle != null;
    }

    @Override
    public void openPage() {
        if(driver != null)
            driver.get(URL);
    }
}
