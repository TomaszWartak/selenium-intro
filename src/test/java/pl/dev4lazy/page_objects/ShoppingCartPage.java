package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.waits.Waiter;

public class ShoppingCartPage extends BasePage {

    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedToCheckoutLink;

    public ShoppingCartPage() {
        super();
        // todo ??? tutaj brakuje pageUrl = ApplicationURLs.???
    }

    public void clickProceedToCheckoutLink() {
        logger.info( System.lineSeparator()+"clickProceedToCheckoutLink");
        Waiter.untilElementIsClickable( proceedToCheckoutLink );
        proceedToCheckoutLink.click();
    }

}
