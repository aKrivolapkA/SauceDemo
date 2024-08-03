package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends HeaderPage {
    public static final By PRODUCT = By.xpath("//*[@data-test='title']");
    public static final String PRODUCT_ITEM = ("//*[text()='%s']/ancestor::*[@class='inventory_item']");
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Add')]";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";
    public static final String CART_BUTTON = "//*[@class= 'shopping_cart_link']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductText() {
        return driver.findElement(PRODUCT).getText();
    }

    @Description("добавления товара в корзину")
    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    @Description("проверка видно ли  товар в корзине")
    public boolean isAddCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    @Description("проверка видно ли  кнопку [Remove]")
    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    @Description("переход на страницу Cart page")
    public void openCartPage() {
        driver.findElement(By.xpath(CART_BUTTON)).click();

    }
}