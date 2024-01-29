package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;

public class FooterPage {

    @FindBy( id = "Banner")
    private WebElement bannerAfterLoginLogo;

    public FooterPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public boolean isBannerAfterLoginDisplayed() {
        return bannerAfterLoginLogo.isDisplayed();
    }

}
