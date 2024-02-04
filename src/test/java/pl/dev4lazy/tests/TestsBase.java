package pl.dev4lazy.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.dev4lazy.browser_factory.BrowserFactory;
import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.driver_manager.DriverUtils;

public class TestsBase {
    final String APP_URL = "http://przyklady.javastart.pl/jpetstore/";
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        BrowserFactory.setBrowserDriver( BrowserType.CHROME );
//        BrowserFactory.setBrowserDriver( BrowserType.SAFARI );
//        BrowserFactory.setBrowserDriver( BrowserType.FIREFOX );
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage( APP_URL );
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
