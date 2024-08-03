package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage {
    public CheckoutOverviewPage(WebDriver driver) {
        super();
    }

    @FindBy(xpath = "//*[@id= 'finish']")
    WebElement finishButton;
}