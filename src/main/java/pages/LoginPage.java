package pages;

import constans.IConstans;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


/**
 * The type Login page.
 */
public class LoginPage extends BasePage implements IConstans {
    /**
     * The Username input.
     */
    @FindBy(xpath = "//*[@id='user-name']")
    WebElement usernameInput;
    /**
     * The Password input.
     */
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;

    /**
     * The Login button.
     */
    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    /**
     * The Error message.
     */
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
    @Description("открытие страницы")
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
    @Description("вход  с помощью  логина и пароля")
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
    @Description("получение ошибки")
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    /**
     * Wait for page opened login page.
     *
     * @return the login page
     */
    @Description("ожидание что страница будет открыта")
    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

}