package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.waits.Waiter;

public class AngelFishCatalogPage extends PageBase {

    @FindBy( xpath="//a[contains(@href, 'ItemId=EST-2')]")
    private WebElement smallAngelFishAddToCartLink;

    public AngelFishCatalogPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void clickSmallAngelFishAddToCartLink() {
        Waiter.untilElementIsClickable( smallAngelFishAddToCartLink );
        smallAngelFishAddToCartLink.click();
        logger.info("clickSmallAngelFishAddToCartLink");
    }
}
