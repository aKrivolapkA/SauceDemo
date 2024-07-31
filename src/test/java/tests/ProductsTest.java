package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements ITestConstants {
    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isAddCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}