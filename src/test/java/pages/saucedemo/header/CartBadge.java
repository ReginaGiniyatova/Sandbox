package pages.saucedemo.header;

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

    public int getCartItemCount() {
        try {
            WebElement counter = driver.findElement(CART_COUNTER);
            return Integer.parseInt(counter.getText());
        } catch (NoSuchElementException | NumberFormatException e) {
            return 0;
        }
    }

    public void click() {
        WebElement cart = driver.findElement(CART);
        cart.click();
    }
}
