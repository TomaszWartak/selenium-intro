package pl.dev4lazy.driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.dev4lazy.utils.SystemInfo;

public class DriverManager {
    final static String WIN_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final static String MAC_DRIVER_PATH = "/usr/local/bin/chromedriver";

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        initWebDriver();
        return driver;
    }

    public static void initWebDriver() {
        if (driver == null) {
            System.setProperty( "webdriver.chrome.driver", getDriverPath() );
            driver = new ChromeDriver();
        }
    }

    private static String getDriverPath() {
        switch (SystemInfo.getOSId()) {
            case SystemInfo.MAC_OS_ID: {
                return MAC_DRIVER_PATH;
            }
            case SystemInfo.WIN_OS_ID: {
                return WIN_DRIVER_PATH;
            }
            case SystemInfo.OTHER_OS_ID: {
                return WIN_DRIVER_PATH;
            }
            default: {
                return WIN_DRIVER_PATH;
            }
        }
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
