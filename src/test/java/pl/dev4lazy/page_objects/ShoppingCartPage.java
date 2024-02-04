package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.waits.Waiter;

public class ShoppingCartPage extends PageBase {

    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedToCheckoutLink;

    public ShoppingCartPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void clickProceedToCheckoutLink() {
        Waiter.untilElementIsClickable( proceedToCheckoutLink );
        proceedToCheckoutLink.click();
        logger.info("clickProceedToCheckoutLink");
    }

}
