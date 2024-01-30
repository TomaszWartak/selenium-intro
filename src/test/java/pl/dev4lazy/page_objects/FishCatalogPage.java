package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.waits.Waiter;

public class FishCatalogPage {

    @FindBy( linkText="FI-SW-01")
    WebElement angelFishIdLink;

    public FishCatalogPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void clickAngelFishIdLink() {
        Waiter.untilElementIsClickable( angelFishIdLink );
        angelFishIdLink.click();
    }
}
