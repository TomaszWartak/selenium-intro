package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.navigation.ApplicationURLs;
import pl.dev4lazy.waits.Waiter;

public class MainPage extends BasePage {

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
        super();
        pageUrl = ApplicationURLs.TOP_MENU_URL;
    }

    public void clickSignInLink() {
        logger.info( System.lineSeparator()+"clickSignInLink");
        Waiter.untilElementIsClickable( signInLink );
        signInLink.click();
    }

    public void clickFishLinkFromTopMenu() {
        logger.info( System.lineSeparator()+"clickFishLinkFromTopMenu");
        Waiter.untilElementIsClickable( fishLink );
        fishLink.click();
    }

    public void clickDogsLinkFromTopMenu() {
        logger.info( System.lineSeparator()+"clickDogsLinkFromTopMenu");
        Waiter.untilElementIsClickable( dogsLink );
        dogsLink.click();
    }

    public void clickCatsLinkFromTopMenu() {
        logger.info( System.lineSeparator()+"clickCatsLinkFromTopMenu");
        Waiter.untilElementIsClickable( catsLink );
        catsLink.click();
    }

    public void clickReptilesLinkFromTopMenu() {
        logger.info( System.lineSeparator()+"clickReptilesLinkFromTopMenu");
        Waiter.untilElementIsClickable( reptilesLink );
        reptilesLink.click();
    }

    public void clickBirdsLinkFromTopMenu() {
        logger.info( System.lineSeparator()+"clickBirdsLinkFromTopMenu");
        Waiter.untilElementIsClickable( birdsLink );
        birdsLink.click();
    }
}
