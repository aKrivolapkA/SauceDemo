package pages;

import constans.IConstans;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage implements IConstans {

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    public static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    public static final String PRODUCT_REMOVE = PRODUCT_ITEM + "//button";
    public static final String PRODUCT_CONTAINER = "//*[@class='cart_item']";
    public static final String CHECKOUT_BUTTON = "//*[@id= 'checkout']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Description("открытие страницы")
    public CartPage openPage() {
        driver.get(CART_PAGE_URL);
        return this;
    }

    @Description("удаление товара из корзины")
    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_REMOVE, productName))).click();
    }

    @Description("получение цены товара")
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    @Description("проверка количества товара")
    public int getProductsCount() {
        return driver.findElements(By.xpath(PRODUCT_CONTAINER)).size();
    }

    @Description("проверка имеется ли товар")
    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    @Description("переход на страницу Checkout page")
    public CheckoutPage openCheckoutPage() {
        driver.findElement(By.xpath(CHECKOUT_BUTTON)).click();
        return new CheckoutPage(driver);

    }

}