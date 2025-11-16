package tests.saucedemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductPageTest extends BaseTest {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void addOneProductTest() {
        productPage.addToCart("Sauce Labs Backpack");
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), 1);
    }

    @Test
    public void addSomeProductsTest() {
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bolt T-Shirt");
        productPage.addToCart("Sauce Labs Fleece Jacket");
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), 4);
    }

    @Test
    public void removeSomeProductsTest() {
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bolt T-Shirt");
        productPage.addToCart("Sauce Labs Fleece Jacket");
        productPage.removeFromCart("Sauce Labs Backpack");
        productPage.removeFromCart("Sauce Labs Fleece Jacket");
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), 2);
    }

    @Test
    public void removeAllAddedProducts() {
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bolt T-Shirt");
        productPage.addToCart("Sauce Labs Fleece Jacket");
        productPage.removeFromCart("Sauce Labs Bike Light");
        productPage.removeFromCart("Sauce Labs Backpack");
        productPage.removeFromCart("Sauce Labs Bolt T-Shirt");
        productPage.removeFromCart("Sauce Labs Fleece Jacket");
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), 0);
    }
}
