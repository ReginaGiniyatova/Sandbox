package pages.saucedemo;

import io.qameta.allure.Step;
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

    @Step("Начинаем процесс авторизации пользователя")
    public ProductPage login(User user) {
        fillLoginInput(user.getLogin());
        fillPasswordInput(user.getPassword());
        clickLoginButton();

        return new ProductPage(driver, wait);
    }

    @Step("Вводим логин пользователя: {login}")
    private void fillLoginInput(String login) {
        WebElement usernameInput = driver.findElement(USERNAME);
        usernameInput.sendKeys(login);
    }

    @Step("Вводим пароль пользовател: {password}")
    private void fillPasswordInput(String password) {
        WebElement passwordInput = driver.findElement(PASSWORD);
        passwordInput.sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    private void clickLoginButton() {
        WebElement loginBtn = driver.findElement(LOGIN_BTN);
        loginBtn.click();
    }

    @Step("Проверяем сообщение об ошибке")
    public String getErrorMsg() {
        WebElement errorMsg = driver.findElement(ERROR_MSG);
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }

    @Step("Открываем страницу авторизации")
    @Override
    public void openPage() {
        if(driver != null)
            driver.get(URL);
    }
}
