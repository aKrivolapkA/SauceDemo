package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Products page.
 */
public class ProductsPage extends HeaderPage {
    /**
     * The constant PRODUCT.
     */
    public static final By PRODUCT = By.xpath("//*[@data-test='title']");
    /**
     * The constant PRODUCT_ITEM.
     */
    public static final String PRODUCT_ITEM = ("//*[text()='%s']/ancestor::*[@class='inventory_item']");
    /**
     * The constant ADD_PRODUCT_TO_CART_BUTTON.
     */
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Add')]";
    /**
     * The constant REMOVE_PRODUCT_FROM_CART_BUTTON.
     */
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";
    /**
     * The constant CART_BUTTON.
     */
    public static final String CART_BUTTON = "//*[@class= 'shopping_cart_link']";

    /**
     * Instantiates a new Products page.
     *
     * @param driver the driver
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets product text.
     *
     * @return the product text
     */
    public String getProductText() {
        return driver.findElement(PRODUCT).getText();
    }

    /**
     * Add product to cart products page.
     *
     * @param productName the product name
     * @return the products page
     */
    @Description("добавления товара в корзину")
    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    /**
     * Is add cart button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    @Description("проверка видно ли  товар в корзине")
    public boolean isAddCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Is remove button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    @Description("проверка видно ли  кнопку [Remove]")
    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Open cart page cart page.
     *
     * @return the cart page
     */
    @Description("переход на страницу Cart page")
    public CartPage openCartPage() {
        driver.findElement(By.xpath(CART_BUTTON)).click();
        return new CartPage(driver);

    }
}