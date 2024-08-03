package pages;

import com.google.common.annotations.VisibleForTesting;
import constans.IConstans;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class LoginPage extends BasePage implements IConstans {
    @FindBy(xpath = "//*[@id='user-name']")
    WebElement usernameInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Description("открытие страницы")
    public LoginPage openPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    @Description("вход  с помощью  логина и пароля")
    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    @Description("получение ошибки")
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Description("ожидание что страница будет открыта")
    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

}