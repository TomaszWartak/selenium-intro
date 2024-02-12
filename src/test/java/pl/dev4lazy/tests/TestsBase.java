package pl.dev4lazy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pl.dev4lazy.browser_factory.BrowserDriverFactory;
import pl.dev4lazy.configuration.PropertiesWrapper;
import pl.dev4lazy.configuration.LocalWebDriverProperties;
import pl.dev4lazy.configuration.PropertiesLoader;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.driver_manager.DriverUtils;

import java.util.Properties;

public class TestsBase {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile
                = propertiesLoader.getPropertiesFromFile("configuration.properties" );
        PropertiesWrapper.setProperties( propertiesFromFile );
    }

    @BeforeMethod
    public void beforeTest() {
        BrowserDriverFactory.setBrowserDriver( LocalWebDriverProperties.getLocalBrowser() );
//        BrowserDriverFactory.setBrowserDriver( BrowserType.CHROME );
//        BrowserDriverFactory.setBrowserDriver( BrowserType.SAFARI );
//        BrowserDriverFactory.setBrowserDriver( BrowserType.FIREFOX );
        DriverUtils.setInitialConfiguration();
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
