package pl.dev4lazy.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.locators.Locator;

public class TopMenuPage {

    @FindBy( linkText = "Sign In")
    WebElement signInLink;
    @FindBy( xpath = "//div[@id='QuickLinks']//img[contains(@src,'fish')]")
    WebElement fishLink;

    public TopMenuPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickFishLink() {
        fishLink.click();
    }
}
