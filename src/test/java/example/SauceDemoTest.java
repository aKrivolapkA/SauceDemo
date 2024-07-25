package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest {

    SauceDemoInfo sauceDemoInfo = new SauceDemoInfo();

    @Test(enabled = false)
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        SauceDemoInfo sauceDemoInfo = new SauceDemoInfo();
        WebElement userName = driver.findElement(By.xpath(sauceDemoInfo.USERNAME_INPUT));
        WebElement password = driver.findElement(By.xpath(sauceDemoInfo.PASSWORD_INPUT));
        WebElement loginButton = driver.findElement(By.xpath(sauceDemoInfo.LOGIN_BUTTON));
        userName.sendKeys(sauceDemoInfo.USERNAME);
        password.sendKeys(sauceDemoInfo.PASSWORD);
        loginButton.click();

    }

    @Test(enabled = false)
    public void addFirstProductToCartTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        SauceDemoInfo sauceDemoInfo = new SauceDemoInfo();
        WebElement userName = driver.findElement(By.xpath(sauceDemoInfo.USERNAME_INPUT));
        WebElement password = driver.findElement(By.xpath(sauceDemoInfo.PASSWORD_INPUT));
        WebElement loginButton = driver.findElement(By.xpath(sauceDemoInfo.LOGIN_BUTTON));
        userName.sendKeys(sauceDemoInfo.USERNAME);
        password.sendKeys(sauceDemoInfo.PASSWORD);
        loginButton.click();
        List<WebElement> products = driver.findElements(By.xpath(sauceDemoInfo.ELEMENTS_LIST));
        products.get(0).click();
        driver.quit();
    }

    @Test
    public void addSecondProductToCartTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        SauceDemoInfo sauceDemoInfo = new SauceDemoInfo();
        WebElement userName = driver.findElement(By.xpath(sauceDemoInfo.USERNAME_INPUT));
        WebElement password = driver.findElement(By.xpath(sauceDemoInfo.PASSWORD_INPUT));
        WebElement loginButton = driver.findElement(By.xpath(sauceDemoInfo.LOGIN_BUTTON));
        userName.sendKeys(sauceDemoInfo.USERNAME);
        password.sendKeys(sauceDemoInfo.PASSWORD);
        loginButton.click();
        WebElement addButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addButton.click();
        WebElement addButton2 = driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        addButton2.click();
        WebElement filterDropDown = driver.findElement(By.className("product_sort_container"));
        filterDropDown.click();
        //WebElement linkText = driver.findElement(By.linkText("LinkedIn"));
        //linkText.click();
       // WebElement text = driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']"));
       //text.click();
        WebElement text = driver.findElement(By.xpath("//*[contains(text(),' Onesie')]"));
        text.click();
        WebElement text2 =  driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));



        //pricebar
        //driver.quit();
    }

}
