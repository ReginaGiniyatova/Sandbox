package tests.saucedemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductPageTest extends BaseTest {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    @DataProvider
    public Object[][] productsData() {
        return new Object[][] {
                {List.of("Sauce Labs Backpack")},
                {List.of("Sauce Labs Bike Light", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket")},
                {List.of("Sauce Labs Bike Light", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie")}
        };
    }

    @Test(dataProvider = "productsData")
    public void addProductsTest(List<String> productNames) {
        productPage.addToCart(productNames);
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), productNames.size());
    }

    @Test(dataProvider = "productsData")
    public void removeAllAddedProducts(List<String> productsNames) {
        productPage.addToCart(productsNames);
        productPage.removeFromCart(productsNames);
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), 0);
    }
}
