package pages;

import jdk.jfr.Description;
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

    /**
     * The First name input.
     */
    @FindBy(xpath = "//*[@id='first-name']")
    WebElement firstNameInput;
    /**
     * The Last name input.
     */
    @FindBy(xpath = "//*[@id='last-name']")
    WebElement lastNameInput;
    /**
     * The Zip code input.
     */
    @FindBy(xpath = "//*[@id='postal-code']")
    WebElement zipCodeInput;

    /**
     * The Continue button.
     */
    @FindBy(xpath = "//*[@id='continue']")
    WebElement continueButton;

    /**
     * The Cancel button.
     */
    @FindBy(xpath = "//*[@id='cancel']")
    WebElement cancelButton;
    /**
     * The Error message.
     */
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    /**
     * Gets error message text.
     *
     * @return the error message text
     */
    @Description("получение ошибки")
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
    @Description("заполнение формы Checkout")
    public void inputCheckoutInformation(String firstName, String lastName, String zipCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(zipCode);
        continueButton.click();
    }

}