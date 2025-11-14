package pages.saucedemo.header;

import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    private CartBadge cartBadge;

    public Header(WebDriver driver) {
        this.driver = driver;
        cartBadge = new CartBadge(driver);
    }

    public CartBadge getCartBadge() {
        return cartBadge;
    }
}
