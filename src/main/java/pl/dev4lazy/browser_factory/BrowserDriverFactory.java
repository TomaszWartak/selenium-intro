package pl.dev4lazy.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import pl.dev4lazy.AppConfig;
import pl.dev4lazy.configuration.TestRunProperties;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.web_drivers.ChromeWebDriver;
import pl.dev4lazy.web_drivers.FirefoxWebDriver;
import pl.dev4lazy.web_drivers.SafariWebDriver;
import pl.dev4lazy.web_drivers.WebDriverExtender;

import java.net.MalformedURLException;
import java.net.URL;

import static pl.dev4lazy.browser_factory.BrowserType.CHROME;

/*
Cechy jakie musi wspierać nowa implementacja klasy BrowserFactory to:
	• Umożliwia wybór przeglądarki.
	• Dostarcza implementację lokalną lub zdalną obiektu WebDrivera.
	• Użytkownik nie powinien mieć możliwości utworzenia obiektu BrowserFactory
	bez podania przeglądarki oraz tego czy uruchomienie testów ma odbyć się lokalnie czy na Selenium GRID.

 */
public class BrowserDriverFactory {

    // TODO usuń
/*
    public BrowserDriverFactory( boolean isRemote ) {

    }
*/

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
    public WebDriver getBrowserDriver( BrowserType browserType ) {
        boolean remoteRun = TestRunProperties.isRemoteRun();
        WebDriverExtender driver;
        if (remoteRun) {
            //Tworzymy obiekt desiredCapabilities, który jest wymagany do wyboru przeglądarki
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            switch (browserType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge( chromeOptions );
                    return getRemoteWebDriver( desiredCapabilities );
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge( firefoxOptions );
                    return getRemoteWebDriver( desiredCapabilities );
                case SAFARI:
                    SafariOptions safariOptions = new SafariOptions();
                    desiredCapabilities.merge( safariOptions);
                    return getRemoteWebDriver( desiredCapabilities );
                default:
                    throw new IllegalStateException( "Unsupported browser...");
            }
        } else {
            switch (browserType) {
                case CHROME:
                    driver = new ChromeWebDriver();
                    System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
                    break;
                case FIREFOX:
                    driver = new FirefoxWebDriver();
                    System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
                    break;
                case SAFARI:
                    driver = new SafariWebDriver();
                    System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
                    break;
                default:
                    throw new IllegalStateException("Unknown browser type! Please check your configuration");
            }
        }
        return driver;
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;
        //Zauważ, że RemoteWebDriver znajduje się w bloku try-catch. Wynika to z faktu, że obiekt URL rzuca wyjątkiem MalformedURLException
        try {
            remoteWebDriver = new RemoteWebDriver(new URL( TestRunProperties.getGridUrl() ), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;
    }
}
