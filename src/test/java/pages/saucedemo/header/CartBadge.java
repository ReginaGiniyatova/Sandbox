package pages.saucedemo.header;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartBadge {
    private final static By CART = new By.ByCssSelector("#shopping_cart_container");
    private final static By CART_COUNTER = new By.ByCssSelector("span[data-test='shopping-cart-badge']");

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
