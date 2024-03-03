package pl.dev4lazy.driver_manager;

import org.openqa.selenium.WebDriver;
import pl.dev4lazy.configuration.TestRunProperties;
import pl.dev4lazy.listeners.WebDriverEventListenerRegistrar;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            WebDriver driver = new BrowserDriverFactory( ).getBrowserDriver( TestRunProperties.getBrowserToRun() );
            driver = WebDriverEventListenerRegistrar.registerWebDriverEventListener( driver );
            //Wywołanie metody getBrowser() z klasy BrowserFactory zwraca instancję WebDrivera, który następnie jest
            // dodana do puli instancji klasy ThreadLocal za pomocą metody set()
            webDriverThreadLocal.set( driver );
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver(){
        webDriverThreadLocal.get().close();
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }
}
