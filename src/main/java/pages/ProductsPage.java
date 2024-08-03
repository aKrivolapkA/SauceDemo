package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Products page.
 */
public class ProductsPage extends HeaderPage {
    @FindBy(xpath = "//*[@data-test='title']")
    WebElement product;

    public static final String PRODUCT_ITEM = ("//*[text()='%s']/ancestor::*[@class='inventory_item']");

    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Add')]";

    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(), 'Remove')]";

    @FindBy(xpath ="//*[@class= 'shopping_cart_link']" )
    WebElement cartButton;


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
        return product.getText();
    }

    /**
     * Add product to cart products page.
     *
     * @param productName the product name
     * @return the products page
     */

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

    public boolean isAddCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Is remove button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */

    public boolean isRemoveButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Open cart page.
     *
     * @return the cart page
     */

    public CartPage proceedToCartPage() {
        cartButton.click();
        return new CartPage(driver);

    }
}