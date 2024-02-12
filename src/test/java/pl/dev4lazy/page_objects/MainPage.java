package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.navigation.ApplicationURLs;
import pl.dev4lazy.waits.Waiter;

public class MainPage extends PageBase {

    @FindBy( linkText = "Sign In")
    WebElement signInLink;

    @FindBy( xpath = "//div[@id='QuickLinks']//img[contains(@src,'fish')]")
    WebElement fishLink;

    @FindBy( xpath = "//div[@id='QuickLinks']//img[contains(@src,'dogs')]")
    WebElement dogsLink;

    @FindBy( xpath = "//div[@id='QuickLinks']//img[contains(@src,'cats')]")
    WebElement catsLink;

    @FindBy( xpath = "//div[@id='QuickLinks']//img[contains(@src,'reptiles')]")
    WebElement reptilesLink;

    @FindBy( xpath = "//div[@id='QuickLinks']//img[contains(@src,'birds')]")
    WebElement birdsLink;

    public MainPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
        pageUrl = ApplicationURLs.TOP_MENU_URL;
    }

    public void clickSignInLink() {
        Waiter.untilElementIsClickable( signInLink );
        signInLink.click();
        logger.info("clickSignInLink");
    }

    public void clickFishLinkFromTopMenu() {
        Waiter.untilElementIsClickable( fishLink );
        fishLink.click();
        logger.info("clickFishLinkFromTopMenu");
    }

    public void clickDogsLinkFromTopMenu() {
        Waiter.untilElementIsClickable( dogsLink );
        dogsLink.click();
        logger.info("clickDogsLinkFromTopMenu");
    }

    public void clickCatsLinkFromTopMenu() {
        Waiter.untilElementIsClickable( catsLink );
        catsLink.click();
        logger.info("clickCatsLinkFromTopMenu");
    }

    public void clickReptilesLinkFromTopMenu() {
        Waiter.untilElementIsClickable( reptilesLink );
        reptilesLink.click();
        logger.info("clickReptilesLinkFromTopMenu");
    }

    public void clickBirdsLinkFromTopMenu() {
        Waiter.untilElementIsClickable( birdsLink );
        birdsLink.click();
        logger.info("clickBirdsLinkFromTopMenu");
    }
}
