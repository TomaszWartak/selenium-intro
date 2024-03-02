package pl.dev4lazy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pl.dev4lazy.AppConfig;
import pl.dev4lazy.browser_factory.BrowserDriverFactory;
import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.configuration.PropertiesContainer;
import pl.dev4lazy.configuration.LocalWebDriverProperties;
import pl.dev4lazy.configuration.PropertiesLoader;
import pl.dev4lazy.configuration.TestRunProperties;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.driver_manager.DriverUtils;

import java.util.Properties;

public class TestsBase {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile
                = propertiesLoader.getPropertiesFromFile( AppConfig.PROPERTIES_FILE_NAME );
        PropertiesContainer.setProperties( propertiesFromFile );
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeTest( @Optional String browser ) {
        TestRunProperties.setBrowserToRun( browser );
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
