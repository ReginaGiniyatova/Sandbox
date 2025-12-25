package tests.saucedemo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.TestDataProvider;

import java.util.List;
import static org.testng.Assert.assertEquals;

public class CartPageTest extends BaseTest {
    @Parameters({"browser"})
    @BeforeMethod
    @Override
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        super.setUp(browser, context);

        productPage.openPage();
    }

    @Epic("Модуль корзины товаров интернет-магазина")
    @Feature("Взаимодествие с корзиной товаров")
    @Owner("Giniyatova Regina")
    @Test(description = "Тест проверки количества добавленных товаров в корзину", dataProvider = "productsData", dataProviderClass = TestDataProvider.class)
    public void getProductsCount(List<String> productsName) {
        productPage.addToCart(productsName);
        productPage.getHeader().getCartBadge().click();
        assertEquals(cartPage.getProductsName().size(), productsName.size());
    }
}
