package tests.saucedemo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.*;
import user.USER_TYPES;
import user.UserFactory;
import utils.TestDataProvider;

import java.util.List;
import static org.testng.Assert.assertEquals;

public class ProductPageTest extends BaseTest {
    @Parameters({"browser"})
    @BeforeMethod
    @Override
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        super.setUp(browser, context);

        loginPage.openPage();
        loginPage.login(UserFactory.create(USER_TYPES.STANDARD));
    }

    @Epic("Модуль списка товаров интернет-магазина")
    @Feature("Взаимодествие с списком товаров")
    @Owner("Giniyatova Regina")
    @Test(description = "Тест добавление товаров в корзину", dataProvider = "productsData", dataProviderClass = TestDataProvider.class)
    public void addProductsTest(List<String> productNames) {
        productPage.addToCart(productNames);
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), productNames.size());
    }

    @Epic("Модуль списка товаров интернет-магазина")
    @Feature("Взаимодествие с списком товаров")
    @Owner("Giniyatova Regina")
    @Test(description = "Тест добавления и удаления товаров из корзины", dataProvider = "productsData", dataProviderClass = TestDataProvider.class)
    public void removeAllAddedProducts(List<String> productsNames) {
        productPage.addToCart(productsNames);
        productPage.removeFromCart(productsNames);
        assertEquals(productPage.getHeader().getCartBadge().getCartItemCount(), 0);
    }
}
