package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The type Checkout page.
 */
public class CheckoutPage extends HeaderPage {
    /**
     * Instantiates a new Checkout page.
     *
     * @param driver the driver
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='first-name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='last-name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='postal-code']")
    WebElement zipCodeInput;

    @FindBy(xpath = "//*[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id='cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    /**
     * Input checkout information.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param zipCode   the zip code
     */
    public CheckoutOverviewPage inputCheckoutInformation(String firstName, String lastName, String zipCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(zipCode);
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }

}