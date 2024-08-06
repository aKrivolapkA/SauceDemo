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

    @DataProvider(name = "products And Price data")//хранилище данных - должно быть название и данные которые хранятся
    public Object[][] productsAndPriceData() {
        return new Object[][]{
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"},
                {T_SHIRT_R5ED,"$15.99"}
        };
    }
        /**
         * Add product to cart test.
         */
//добавить товар в корзину и проверить что у него отображается верная цена
        @Test(alwaysRun = true, dataProvider = "products And Price data")
        public void addProductToCartTest(String productName, String price) {
            loginPage.openPage()
                    .login(USERNAME, PASSWORD)
                    .addProductToCart(productName);
            cartPage.openPage();
            Assert.assertEquals(cartPage.getProductPrice(productName), price);
        }

        /**
         * Add two products to cart and check count test.
         */
//добавить 2 товара в корзину и проверить что количество добавленных товаров равно 2
        @Test
        public void addTwoProductsToCartAndCheckCountTest () {
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
        @Test(dataProvider = "products",groups = "dataProvider")
        public void removeOneProductFromCartTest (String productName){
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
        public void removeProductFromCartAndCheckCountTest () {
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