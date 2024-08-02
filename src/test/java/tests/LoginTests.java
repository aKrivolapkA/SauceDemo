package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest implements ITestConstants {

    private static final String EMPTY_PASSWORD_ERROR_TEXT = "Epic sadface: Password is required";
    private static final String EMPTY_USER_NAME_ERROR_TEXT = "Epic sadface: Username is required";
    private static final String EMPTY_USER_NAME_ERROR_TEXT_ERROR = "Epic sadface:  is required";
    private static final String INCORRECT_DATA_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USER_NAME_ERROR_TEXT);
    }
    @Test(retryAnalyzer = Retry.class)
    public void loginWithEmptyFieldsTestWithRetry() {
        loginPage
                .openPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USER_NAME_ERROR_TEXT_ERROR);
    }

    @Test
    public void loginWithEmptyUserNameFieldsTest() {
        loginPage
                .openPage()
                .login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USER_NAME_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordFieldTest() {
        loginPage
                .openPage()
                .login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest() {
        loginPage
                .openPage()
                .login("dddd", "ssss");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_ERROR_TEXT);
    }

    @Test
    public void loginWithCorrectDataTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD);
        driver.getCurrentUrl();
        Assert.assertEquals(productsPage.getProductText(), "Products");
    }

    // в браузере делать разные действия
    public void lo1() {
        Actions actions = new Actions(driver);
        actions.doubleClick();
    }

    // ниже отличие обычного использования и PageFactory
    @FindBy(xpath = "//*[contains(text(),'Add E')]")
    WebElement addButton;

    @FindBy(xpath = "//*[contains(text(),'Delete')]")
    WebElement removeButton;

    @Test
    public void addWithoutPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//*[contains(text(),'Add E')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//*[contains(text(),'Delete')]"));
        deleteButton.click();
        addButton.click();
        // deleteButton.click(); //StaleElementReferenceException  кнопка вроде та же но нет
    }

    @Test
    public void addWithPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButtonPageFactory = addButton;
        addButtonPageFactory.click();
        WebElement deleteButtonPageFactory = removeButton;
        deleteButtonPageFactory.click();
        addButtonPageFactory.click();
        deleteButtonPageFactory.click();
    }
}