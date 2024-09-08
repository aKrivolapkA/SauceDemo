package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductsPage;

public class CartSteps {
    private CartPage cartPage;
    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }
}
