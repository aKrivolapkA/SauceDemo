package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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

    @Test
    @Parameters ({"username","password"}) // данные передаем в LoginTests.xml
    public void loginWithParametersTest(@Optional("optionalUserName") String username, @Optional("optionalPassword")String password) { //Optional  если не будет переданно в LoginTests.xml
        loginPage
                .openPage()
                .login(username, password);
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_ERROR_TEXT);
    }

    @Test
    public void loginTestWithSystemParameters() { //чтобы запустить % mvn -Dtest=LoginTest #loginTestWithSystemParameters -Dusername=standard_user -Dpassword=secret_sauce test


        loginPage
                .openPage()
                .waitForPageOpened()
                .login(System.getProperty("username","123"),System.getProperty("password","123"));
        driver.getCurrentUrl();
        Assert.assertEquals(productsPage.getProductText(), "Products");
    }
}