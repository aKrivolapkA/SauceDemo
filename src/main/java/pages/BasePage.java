package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * The type Base page.
 */
public abstract class BasePage {
    WebDriver driver;

    /**
     * Instantiates a new Base page.
     *
     * @param driver the driver
     */
    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Open page.
     *
     * @param url the url
     */
    public void openPage(String url) {
        driver.get(url);
    }
}