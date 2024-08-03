package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.ITestConstants.*;

/**
 * The type Checkout tests.
 */
public class CheckoutTests extends BaseTest {

    /**
     * Filling in all fields on the checkout page test.
     */
    @Test
    public void fillingInAllFieldsOnTheCheckoutPageTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.proceedToCartPage();
        cartPage
                .proceedToCheckoutPage()
                .inputCheckoutInformation("aaa", "ddd", "1234");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id= 'finish']")).isDisplayed());
    }

    /**
     * Filling fields without first name on the checkout page test.
     */
    @Test
    public void fillingFieldsWithoutFirstName() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.proceedToCartPage();
        cartPage
                .proceedToCheckoutPage()
                .inputCheckoutInformation("", "ddd", "1234");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: First Name is required");
    }

    /**
     * Filling fields without last name on the checkout page test.
     */
    @Test
    public void fillingFieldsWithoutLastName() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.proceedToCartPage();
        cartPage
                .proceedToCheckoutPage()
                .inputCheckoutInformation("test", "", "1234");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is required");
    }

    /**
     * Filling fields without zip code on the checkout page test.
     */
    @Test
    public void fillingFieldsWithoutZipCode() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.proceedToCartPage();
        cartPage
                .proceedToCheckoutPage()
                .inputCheckoutInformation("test", "test", "");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Postal Code is required");
    }

    /**
     * Filling all fields where firstname with space on the checkout page test.
     */
    @Test
    public void fillingAllFieldsWhereFirstnameSpace() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.proceedToCartPage();
        cartPage
                .proceedToCheckoutPage()
                .inputCheckoutInformation(" ", "ddd", "1234");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id= 'finish']")).isDisplayed());
    }
}