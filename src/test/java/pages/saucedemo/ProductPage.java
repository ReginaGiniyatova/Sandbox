package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.saucedemo.header.Header;

import java.util.List;

public class ProductPage extends BasePage {

    private final static String PRODUCT_ADD_CART = "//div[text()='%s']//ancestor::div[@class='inventory_item_description']//button[text()='Add to cart']";
    private final static String PRODUCT_REMOVE_CART = "//div[text()='%s']//ancestor::div[@class='inventory_item_description']//button[text()='Remove']";
    private final By PRODUCT_TITLE = By.cssSelector("span[data-test='title']");

    private Header header;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        header = new Header(driver);
    }

    @Override
    public void openPage() {
    }

    public boolean hasProductTitle() {
        try {
            WebElement title = driver.findElement(PRODUCT_TITLE);
            return title.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void addToCart(String name) {
        WebElement addBtn = driver.findElement(By.xpath(PRODUCT_ADD_CART.formatted(name)));
        addBtn.click();
    }

    public void removeFromCart(String name) {
        WebElement removeBtn = driver.findElement(By.xpath(PRODUCT_REMOVE_CART.formatted(name)));
        removeBtn.click();
    }

    public void addToCart(List<String> names) {
        for(String name : names) {
            addToCart(name);
        }
    }

    public void removeFromCart(List<String> names) {
        for(String name : names) {
            removeFromCart(name);
        }
    }

    public Header getHeader() {
        return header;
    }
}
