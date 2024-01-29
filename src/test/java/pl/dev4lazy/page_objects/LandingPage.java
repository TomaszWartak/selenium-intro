package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;

public class LandingPage {

    @FindBy(linkText = "Enter the Store")
    private WebElement enterTheStoreLink;

    public LandingPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void clickEnterTheStoreLink() {
        enterTheStoreLink.click();
    }
}
