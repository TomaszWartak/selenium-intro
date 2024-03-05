package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.navigation.ApplicationURLs;
import pl.dev4lazy.waits.Waiter;

public class FishCatalogPage extends BasePage {

    @FindBy( linkText="FI-SW-01")
    private WebElement angelFishIdLink;

    public FishCatalogPage() {
        super();
        pageUrl = ApplicationURLs.FISH_CATEGORY_URL;
    }

    public void clickAngelFishIdLink() {
        logger.info( System.lineSeparator()+"clickAngelFishIdLink");
        Waiter.untilElementIsClickable( angelFishIdLink );
        angelFishIdLink.click();
    }
}
