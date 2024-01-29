package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;

public class ShoppingCartPage {

    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedToCheckoutLink;

    public ShoppingCartPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void clickProceedToCheckoutLink() {
        proceedToCheckoutLink.click();
    }

}
