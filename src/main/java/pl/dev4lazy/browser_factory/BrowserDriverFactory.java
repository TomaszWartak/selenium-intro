package pl.dev4lazy.browser_factory;

import org.openqa.selenium.WebDriver;
import pl.dev4lazy.AppConfig;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.web_drivers.ChromeWebDriver;
import pl.dev4lazy.web_drivers.FirefoxWebDriver;
import pl.dev4lazy.web_drivers.SafariWebDriver;
import pl.dev4lazy.web_drivers.WebDriverExtender;

import static pl.dev4lazy.browser_factory.BrowserType.CHROME;

/*
Cechy jakie musi wspierać nowa implementacja klasy BrowserFactory to:
	• Umożliwia wybór przeglądarki.
	• Dostarcza implementację lokalną lub zdalną obiektu WebDrivera.
	• Użytkownik nie powinien mieć możliwości utworzenia obiektu BrowserFactory
	bez podania przeglądarki oraz tego czy uruchomienie testów ma odbyć się lokalnie czy na Selenium GRID.

 */
public class BrowserDriverFactory {

    public BrowserDriverFactory( boolean isRemote ) {

    }

    // TODO usuń
    /*public static void setBrowserDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                DriverManager.initWebDriver(
                        AppConfig.getInstance().getDriverPath( browserType ),
                        new ChromeWebDriver()
                );
                break;
            case FIREFOX:
                DriverManager.initWebDriver(
                        AppConfig.getInstance().getDriverPath( browserType ),
                        new FirefoxWebDriver()
                );
                break;
            case SAFARI:
                DriverManager.initWebDriver(
                        AppConfig.getInstance().getDriverPath( browserType ),
                        new SafariWebDriver()
                );
                break;
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
*/
    public WebDriver getBrowserDriver(BrowserType browserType) {
        WebDriverExtender driver;
        switch (browserType) {
            case CHROME:
                driver = new ChromeWebDriver();
                System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
                return driver;
            case FIREFOX:
                driver = new FirefoxWebDriver();
                System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
                return driver;
            case SAFARI:
                driver = new SafariWebDriver();
                System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
                return driver;
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }


}
