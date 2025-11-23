package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

public class LoginPage extends BasePage {

    private final static String URL = "https://www.saucedemo.com/";
    private final By USERNAME = By.cssSelector("#user-name");
    private final By PASSWORD = By.cssSelector("#password");
    private final By LOGIN_BTN = By.cssSelector("#login-button");
    private final By ERROR_MSG = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(User user) {
        WebElement usernameInput = driver.findElement(USERNAME);
        WebElement passwordInput = driver.findElement(PASSWORD);
        WebElement loginBtn = driver.findElement(LOGIN_BTN);

        usernameInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginBtn.click();
    }

    public String getErrorMsg() {
        WebElement errorMsg = driver.findElement(ERROR_MSG);
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }

    @Override
    public void openPage() {
        if(driver != null)
            driver.get(URL);
    }
}
