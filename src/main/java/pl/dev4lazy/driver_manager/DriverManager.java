package pl.dev4lazy.driver_manager;

import org.openqa.selenium.WebDriver;
import pl.dev4lazy.browser_factory.BrowserDriverFactory;
import pl.dev4lazy.configuration.TestRunProperties;
import pl.dev4lazy.web_drivers.WebDriverExtender;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

//    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            //Wywołanie metody getBrowser() z klasy BrowserFactory zwraca instancję WebDrivera, który następnie jest
            // dodana do puli instancji klasy ThreadLocal za pomocą metody set()
            webDriverThreadLocal.set( new BrowserDriverFactory( ).getBrowserDriver( TestRunProperties.getBrowserToRun() ) );
        }
        return webDriverThreadLocal.get();
        /*if (driver == null) {
            driver = new BrowserDriverFactory( ).getBrowserDriver( TestRunProperties.getBrowserToRun() );
        }
        return driver;
        */
    }

    public static void disposeDriver(){
        webDriverThreadLocal.get().close();
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
/*        driver.close();
        driver.quit();
        driver = null;*/
    }
}
