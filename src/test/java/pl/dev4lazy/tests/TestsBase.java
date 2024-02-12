package pl.dev4lazy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.dev4lazy.browser_factory.BrowserDriverFactory;
import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.driver_manager.DriverUtils;

public class TestsBase {
    final String APP_URL = "http://przyklady.javastart.pl/jpetstore/";
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        BrowserDriverFactory.setBrowserDriver( BrowserType.CHROME );
//        BrowserDriverFactory.setBrowserDriver( BrowserType.SAFARI );
//        BrowserDriverFactory.setBrowserDriver( BrowserType.FIREFOX );
        DriverUtils.setInitialConfiguration();
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
