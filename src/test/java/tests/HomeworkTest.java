package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The type Homework test.
 */
public class HomeworkTest {

    private WebDriver driver;
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
     * Sets up.
     */
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        PageFactory.initElements(driver, this);
    }

    /**
     * Login steps.
     */
    @Test
    public void loginSteps() {
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        String logo = driver.findElement(By.xpath("//*[@class='app_logo']")).getText();
        Assert.assertEquals(logo, "Swag Labs");
        driver.findElement(By.xpath("//*[@id ='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@id ='shopping_cart_container']")).click();
        String nameItem = driver.findElement(By.xpath("//*[@id ='item_4_title_link']")).getText();
        Assert.assertEquals(nameItem, "Sauce Labs Backpack");
        String priceItem = driver.findElement(By.xpath("//*[@class ='inventory_item_price']")).getText();
        Assert.assertEquals(priceItem, "$29.99");
        driver.quit();
    }
}