package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static tests.ITestConstants.*;

/**
 * The type Cart tests.
 */
public class CartTests extends BaseTest {


    /**
     * Products object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "products")//хранилище данных - должно быть название и данные которые хранятся
    public Object[] products() {
        return new Object[]{
                SAUCE_LABS_BACKPACK,
                SAUCE_LABS_BIKE_LIGHT,
                SAUCE_LABS_BOLT_T_SHIRT,
                SAUCE_LABS_FLEECE_JACKET,
                SAUCE_LABS_ONESIE,
                T_SHIRT_R5ED
        };
    }

    /**
     * Add product to cart test.
     */
//добавить товар в корзину и проверить что у него отображается верная цена
    @Test
    public void addProductToCartTest() {
        loginPage.openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
    }

    /**
     * Add two products to cart and check count test.
     */
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

    /**
     * Remove one product from cart test.
     *
     * @param productName the product name
     */
    @Test(dataProvider = "products")
    public void removeOneProductFromCartTest(String productName) {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProductToCart(productName);
        cartPage.openPage()
                .removeProductFromCart(productName);
        Assert.assertFalse(cartPage.isProductDisplayed(productName));
    }

    /**
     * Remove product from cart and check count test.
     */
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