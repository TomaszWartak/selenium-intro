package pl.dev4lazy.browser_factory;

import pl.dev4lazy.AppConfig;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.web_drivers.ChromeWebDriver;
import pl.dev4lazy.web_drivers.FirefoxWebDriver;
import pl.dev4lazy.web_drivers.SafariWebDriver;

import static pl.dev4lazy.browser_factory.BrowserType.CHROME;

public class BrowserDriverFactory {

    public static void setBrowserDriver(BrowserType browserType) {
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

}
