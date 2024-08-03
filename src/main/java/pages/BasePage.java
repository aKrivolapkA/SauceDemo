package pages;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Description("открытие страницы")
    public void openPage(String url) {
        driver.get(url);
    }
}