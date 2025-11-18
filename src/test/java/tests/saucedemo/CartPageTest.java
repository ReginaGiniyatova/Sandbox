package tests.saucedemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartPageTest extends BaseTest {
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
    public void getProductsCount(List<String> productsName) {
        productPage.addToCart(productsName);
        productPage.getHeader().getCartBadge().click();
        assertEquals(cartPage.getProductsName().size(), productsName.size());
    }
}
