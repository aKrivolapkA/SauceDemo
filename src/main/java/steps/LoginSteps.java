package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login with username:{username} and password: {password}")
    public LoginSteps loginAndWaitForPageOpened(String username, String password){
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(username, password);
        return this;
    }
}
