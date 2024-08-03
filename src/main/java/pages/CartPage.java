package pages;

import constans.IConstans;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Cart page.
 */
public class CartPage extends HeaderPage implements IConstans {

    /**
     * The constant PRODUCT_ITEM.
     */
    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    /**
     * The constant PRODUCT_PRICE.
     */
    public static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    /**
     * The constant PRODUCT_REMOVE.
     */
    public static final String PRODUCT_REMOVE = PRODUCT_ITEM + "//button";
    /**
     * The constant PRODUCT_CONTAINER.
     */
    public static final String PRODUCT_CONTAINER = "//*[@class='cart_item']";
    /**
     * The constant CHECKOUT_BUTTON.
     */
    public static final String CHECKOUT_BUTTON = "//*[@id= 'checkout']";

    /**
     * Instantiates a new Cart page.
     *
     * @param driver the driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page cart page.
     *
     * @return the cart page
     */
    @Description("открытие страницы")
    public CartPage openPage() {
        driver.get(CART_PAGE_URL);
        return this;
    }

    /**
     * Remove product from cart.
     *
     * @param productName the product name
     */
    @Description("удаление товара из корзины")
    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_REMOVE, productName))).click();
    }

    /**
     * Gets product price.
     *
     * @param productName the product name
     * @return the product price
     */
    @Description("получение цены товара")
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    /**
     * Gets products count.
     *
     * @return the products count
     */
    @Description("проверка количества товара")
    public int getProductsCount() {
        return driver.findElements(By.xpath(PRODUCT_CONTAINER)).size();
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    @Description("проверка имеется ли товар")
    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    /**
     * Open checkout page checkout page.
     *
     * @return the checkout page
     */
    @Description("переход на страницу Checkout page")
    public CheckoutPage openCheckoutPage() {
        driver.findElement(By.xpath(CHECKOUT_BUTTON)).click();
        return new CheckoutPage(driver);

    }

}