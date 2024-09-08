package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsSteps {

    private ProductsPage productsPage;
    private LoginPage loginPage;
    public ProductsSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }

    @Step("Login with username:{username} and password: {password} and product to cart ")
    public ProductsSteps loginAndAddProductToCart(String product){
        //TODO дописать код !
        productsPage.addProductToCart(product);
        return this;
    }
}
