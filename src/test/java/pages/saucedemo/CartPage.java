package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CartPage extends BasePage {

    public final By PRODUCTS_NAME = By.cssSelector("[data-test='inventory-item-name']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public void openPage() {
    }

    public List<String> getProductsName() {
        List<WebElement> productsName = driver.findElements(PRODUCTS_NAME);

        return productsName
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}

