package pages;

import constans.IConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


/**
 * The type Login page.
 */
public class LoginPage extends BasePage implements IConstans {
    @FindBy(xpath = "//*[@id='user-name']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;


    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page login page.
     *
     * @return the login page
     */

    public LoginPage openPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    /**
     * Login products page.
     *
     * @param username the username
     * @param password the password
     * @return the products page
     */

    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    /**
     * Gets error message text.
     *
     * @return the error message text
     */

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    /**
     * Wait for page opened login page.
     *
     * @return the login page
     */

    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

}