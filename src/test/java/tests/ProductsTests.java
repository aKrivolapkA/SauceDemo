package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The type Products tests.
 */
public class ProductsTests extends BaseTest implements ITestConstants {

    /**
     * Is remove button displayed test.
     */
    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}