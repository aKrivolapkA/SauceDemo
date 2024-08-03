package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The type Login tests.
 */
public class LoginTests extends BaseTest implements ITestConstants {

    private static final String EMPTY_PASSWORD_ERROR_TEXT = "Epic sadface: Password is required";
    private static final String EMPTY_USER_NAME_ERROR_TEXT = "Epic sadface: Username is required";
    private static final String EMPTY_USER_NAME_ERROR_TEXT_ERROR = "Epic sadface:  is required";
    private static final String INCORRECT_DATA_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

    /**
     * Login with empty fields test.
     */
    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USER_NAME_ERROR_TEXT);
    }
    // @Test(retryAnalyzer = Retry.class)
    // public void loginWithEmptyFieldsTestWithRetry() {
    //     loginPage
    //             .openPage()
    //             .login("", "");
    //     Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USER_NAME_ERROR_TEXT_ERROR);
    // }

    /**
     * Login with empty user name fields test.
     */
    @Test
    public void loginWithEmptyUserNameFieldsTest() {
        loginPage
                .openPage()
                .login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USER_NAME_ERROR_TEXT);
    }

    /**
     * Login with empty password field test.
     */
    @Test
    public void loginWithEmptyPasswordFieldTest() {
        loginPage
                .openPage()
                .login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_ERROR_TEXT);
    }

    /**
     * Login with incorrect data test.
     */
    @Test
    public void loginWithIncorrectDataTest() {
        loginPage
                .openPage()
                .login("dddd", "ssss");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_ERROR_TEXT);
    }

    /**
     * Login with correct data test.
     */
    @Test
    public void loginWithCorrectDataTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD);
        driver.getCurrentUrl();
        Assert.assertEquals(productsPage.getProductText(), "Products");
    }
}