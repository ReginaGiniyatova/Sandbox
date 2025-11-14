package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final static String URL = "https://www.saucedemo.com/";
    private final static By USERNAME = new By.ByCssSelector("#user-name");
    private final static By PASSWORD = new By.ByCssSelector("#password");
    private final static By LOGIN_BTN = new By.ByCssSelector("#login-button");
    private final static By ERROR_MSG = new By.ByCssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(String username, String password) {
        WebElement usernameInput = driver.findElement(USERNAME);
        WebElement passwordInput = driver.findElement(PASSWORD);
        WebElement loginBtn = driver.findElement(LOGIN_BTN);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    @Override
    public void openPage() {
        if(driver != null)
            driver.get(URL);
    }
}
