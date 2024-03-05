package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.waits.Waiter;

public class FooterPage extends BasePage {

    @FindBy( id = "Banner")
    private WebElement bannerAfterLoginLogo;

    public FooterPage() {
        super();
        // todo ??? tutaj brakuje pageUrl = ApplicationURLs.???
    }

    public boolean isBannerAfterLoginDisplayed() {
        logger.info( System.lineSeparator()+"isBannerAfterLoginDisplayed");
        Waiter.untilElementIsVisible( bannerAfterLoginLogo );
        return bannerAfterLoginLogo.isDisplayed();
    }

}
