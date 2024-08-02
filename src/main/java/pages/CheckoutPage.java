package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends HeaderPage{
    CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//*[@id='first-name']" )
    WebElement firstNameInput;
    @FindBy(xpath ="//*[@id='last-name']" )
    WebElement lastNameInput;
    @FindBy(xpath ="//*[@id='postal-code']" )
    WebElement zipCodeInput;

    @FindBy(xpath ="//*[@id='continue']" )
    WebElement continueButton;

    @FindBy(xpath ="//*[@id='cancel']" )
    WebElement cancelButton;
    @FindBy(xpath ="//h3[@data-test='error']" )
    WebElement errorMessage;
}
