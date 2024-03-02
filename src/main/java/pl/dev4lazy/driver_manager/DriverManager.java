package pl.dev4lazy.driver_manager;

import org.openqa.selenium.WebDriver;
import pl.dev4lazy.browser_factory.BrowserDriverFactory;
import pl.dev4lazy.configuration.TestRunProperties;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            //Wywołanie metody getBrowser() z klasy BrowserFactory zwraca instancję WebDrivera, który następnie jest
            // dodana do puli instancji klasy ThreadLocal za pomocą metody set()
            webDriverThreadLocal.set( new BrowserDriverFactory( ).getBrowserDriver( TestRunProperties.getBrowserToRun() ) );
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver(){
        webDriverThreadLocal.get().close();
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }
}
