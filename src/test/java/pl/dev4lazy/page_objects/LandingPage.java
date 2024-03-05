package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.navigation.ApplicationURLs;
import pl.dev4lazy.waits.Waiter;

public class LandingPage extends BasePage {

    @FindBy(linkText = "Enter the Store")
    private WebElement enterTheStoreLink;

    public LandingPage() {
        super();
        pageUrl = ApplicationURLs.APPLICATION_URL;
    }

    public void clickEnterTheStoreLink() {
        logger.info( System.lineSeparator()+"clickEnterTheStoreLink");
        Waiter.untilElementIsClickable( enterTheStoreLink );
        enterTheStoreLink.click();
    }
}
