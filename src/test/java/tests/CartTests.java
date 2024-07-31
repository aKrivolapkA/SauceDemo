package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.ITestConstants.*;

public class CartTests extends BaseTest {


    //добавить товар в корзину и проверить что у него отображается верная цена
    @Test
    public void addProductToCartTest() {
        loginPage.openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
    }

    //добавить 2 товара в корзину и проверить что количество добавленных товаров равно 2
    @Test
    public void addTwoProductsToCartAndCheckCountTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductsCount(), 2);
    }

    @Test
    public void removeOneProductFromCartTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openPage()
                .removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }

    // удалить товар из корзины и проверить что он удалился
    @Test
    public void removeProductFromCartAndCheckCountTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openPage()
                .removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductsCount(), 1);
    }
}