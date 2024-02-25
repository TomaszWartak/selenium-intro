package pl.dev4lazy.driver_manager;

import org.openqa.selenium.WebDriver;
import pl.dev4lazy.browser_factory.BrowserDriverFactory;
import pl.dev4lazy.configuration.TestRunProperties;
import pl.dev4lazy.web_drivers.WebDriverExtender;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    // TODO USUń
/*
    public static WebDriver getWebDriver1() {
        if (driver == null) {
            throw new IllegalStateException(
                    // TODO tą metodę trzeba usunąć
                    "DriverManager not initalized. "+
                    "Use BrowserFactory to initialize it."
            );
        }
        return driver;
    }
*/

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new BrowserDriverFactory( TestRunProperties.isRemoteRun() ).getBrowserDriver( TestRunProperties.getBrowserToRun() );
        }
        return driver;
    }

    //TODO USUń
    /*public static void initWebDriver( String driverPath, WebDriverExtender webDriverExtender ) {
        if (driver == null) {
            System.setProperty( webDriverExtender.getDriverName(), driverPath );
            driver = webDriverExtender;
        }
    }*/

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
