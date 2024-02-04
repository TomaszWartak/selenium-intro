package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.waits.Waiter;

public class FooterPage extends PageBase {

    @FindBy( id = "Banner")
    private WebElement bannerAfterLoginLogo;

    public FooterPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public boolean isBannerAfterLoginDisplayed() {
        Waiter.untilElementIsVisible( bannerAfterLoginLogo );
        logger.info("isBannerAfterLoginDisplayed");
        return bannerAfterLoginLogo.isDisplayed();
    }

}
