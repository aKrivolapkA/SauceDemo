package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Checkout overview page.
 */
public class CheckoutOverviewPage {
    /**
     * Instantiates a new Checkout overview page.
     *
     * @param driver the driver
     */
    public CheckoutOverviewPage(WebDriver driver) {
        super();
    }

    /**
     * The Finish button.
     */
    @FindBy(xpath = "//*[@id= 'finish']")
    WebElement finishButton;
}