package pages.saucedemo.header;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartBadge {
    private final By CART = By.cssSelector("#shopping_cart_container");
    private final By CART_COUNTER = By.cssSelector("span[data-test='shopping-cart-badge']");

    private WebDriver driver;

    public CartBadge(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверяем число товаров на значке корзины в хедере сайта")
    public int getCartItemCount() {
        try {
            WebElement counter = driver.findElement(CART_COUNTER);
            return Integer.parseInt(counter.getText());
        } catch (NoSuchElementException | NumberFormatException e) {
            return 0;
        }
    }

    @Step("Кликаем по значку корзины в хедере сайта")
    public void click() {
        WebElement cart = driver.findElement(CART);
        cart.click();
    }
}
