package pl.dev4lazy.driver_manager;

import org.openqa.selenium.WebDriver;
import pl.dev4lazy.web_drivers.WebDriverExtender;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            throw new IllegalStateException(
                    "DriverManager not initalized. "+
                    "Use BrowserFactory to initialize it."
            );
        }
        return driver;
    }

    public static void initWebDriver( String driverPath, WebDriverExtender webDriverExtender ) {
        if (driver == null) {
            System.setProperty( webDriverExtender.getDriverName(), driverPath );
            driver = webDriverExtender;
        }
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
