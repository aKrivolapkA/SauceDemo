package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.ITestConstants.*;

public class CheckoutTests extends BaseTest {

    @Test
    public void fillingInAllFieldsOnTheCheckoutPageTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.openCartPage();
        cartPage.openCheckoutPage();
        checkoutPage.inputCheckoutInformation("aaa", "ddd", "1234");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id= 'finish']")).isDisplayed());
    }

    @Test
    public void fillingFieldsWithoutFirstNameOnTheCheckoutPageTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.openCartPage();
        cartPage.openCheckoutPage();
        checkoutPage.inputCheckoutInformation("", "ddd", "1234");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: First Name is required");
    }

    @Test
    public void fillingFieldsWithoutLastNameOnTheCheckoutPageTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.openCartPage();
        cartPage.openCheckoutPage();
        checkoutPage.inputCheckoutInformation("test", "", "1234");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is required");
    }

    @Test
    public void fillingFieldsWithoutZipCodeOnTheCheckoutPageTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.openCartPage();
        cartPage.openCheckoutPage();
        checkoutPage.inputCheckoutInformation("test", "test", "");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Postal Code is required");
    }
    @Test
    public void fillingAllFieldsWhereFirstnameWithSpaceOnTheCheckoutPageTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
        productsPage.openCartPage();
        cartPage.openCheckoutPage();
        checkoutPage.inputCheckoutInformation(" ", "ddd", "1234");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id= 'finish']")).isDisplayed());
    }
}