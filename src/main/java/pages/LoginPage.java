package pages;

import com.google.common.annotations.VisibleForTesting;
import constans.IConstans;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class LoginPage extends BasePage implements IConstans {

    //public static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    //public static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    //public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    //public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    @FindBy(xpath ="//*[@id='user-name']" )
    WebElement usernameInput;
    @FindBy(xpath ="//*[@id='password']" )
    WebElement passwordInput;

    @FindBy(xpath ="//*[@id='login-button']" )
    WebElement loginButton;

    @FindBy(xpath ="//*[@data-test='error']" )
    WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage  openPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }
    public ProductsPage login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }

    public LoginPage waitForPageOpened(){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }


 //   пример где раз на 2 секунды ьудет проверять чтоб появился элемент
  // public void waitForPageOpenedWithFluent(){
  //     Wait<WebDriver> fluent = new FluentWait<>(driver)
  //             .withTimeout(Duration.ofSeconds(30))
  //             .pollingEvery(Duration.ofSeconds(2))
  //             .ignoring(NoSuchElementException.class);
  //     fluent.until(ExpectedConditions.visibilityOfElementLocated(driver.findElement(LOGIN_BUTTON)));
  //
  // }



}