package pages;

import constans.IConstans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * The type Cart page.
 */
public class CartPage extends HeaderPage implements IConstans {

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    WebElement productPrice;

    @FindBy(xpath = "//*[@id= 'checkout']")
    WebElement checkoutButton;

    @FindAll(@FindBy(xpath = "//*[@class='cart_item']"))
    private List<WebElement> productContainers;

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";

    public static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";

    public static final String PRODUCT_REMOVE = PRODUCT_ITEM + "//button";


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
    public CartPage openPage() {
        driver.get(CART_PAGE_URL);
        return this;
    }

    /**
     * Remove product from cart.
     *
     * @param productName the product name
     */
    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(PRODUCT_REMOVE, productName))).click();
    }

    /**
     * Gets product price.
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();

    }

    /**
     * Gets products count.
     *
     * @return the products count
     */
    public int getProductsCount() {
        return productContainers.size();
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayed(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    /**
     * Open checkout page.
     *
     * @return the checkout page
     */
    public CheckoutPage proceedToCheckoutPage() {
        checkoutButton.click();
        return new CheckoutPage(driver);

    }

}