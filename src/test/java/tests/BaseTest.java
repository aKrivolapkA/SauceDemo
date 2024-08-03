package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * The type Base test.
 */
@Listeners(TestListener.class)
// анатоция чтобы в терменале было видно/ можно писать свое и менять/ нужно заимпортиовать ITestListener

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    HeaderPage headerPage;

    /**
     * Init test.
     */
    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();//скачиваем хромдрайвер и сеттаем его в системные настройки
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);//инициализируем обьект веб драйвера
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        PageFactory.initElements(driver, this);
    }

    /**
     * Init pages.
     */
    public void initPages() { //проинициализировали все странички ятобы не создавать экземляры класса каждый раз
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        headerPage = new HeaderPage(driver);


    }

    /**
     * End test.
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}