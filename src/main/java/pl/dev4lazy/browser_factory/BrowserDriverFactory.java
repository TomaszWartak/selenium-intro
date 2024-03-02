package pl.dev4lazy.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import pl.dev4lazy.AppConfig;
import pl.dev4lazy.configuration.TestRunProperties;
import pl.dev4lazy.web_drivers.*;

import java.net.MalformedURLException;
import java.net.URL;

/*
Cechy jakie musi wspierać nowa implementacja klasy BrowserFactory to:
	• Umożliwia wybór przeglądarki.
	• Dostarcza implementację lokalną lub zdalną obiektu WebDrivera.
	• Użytkownik nie powinien mieć możliwości utworzenia obiektu BrowserFactory
	bez podania przeglądarki oraz tego czy uruchomienie testów ma odbyć się lokalnie czy na Selenium GRID.

 */
public class BrowserDriverFactory {

    public WebDriver getBrowserDriver( BrowserType browserType ) {
        boolean remoteRun = TestRunProperties.isRemoteRun();
        if (remoteRun) {
            //Tworzymy obiekt desiredCapabilities, który jest wymagany do wyboru przeglądarki
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            switch (browserType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge( chromeOptions );
                    break;
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge( firefoxOptions );
                    break;
                case SAFARI:
                    SafariOptions safariOptions = new SafariOptions();
                    desiredCapabilities.merge( safariOptions);
                    break;
                case EDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    desiredCapabilities.merge( edgeOptions);
                    break;
                default:
                    throw new IllegalStateException( "Unsupported browser...");
            }
            return getRemoteWebDriver( desiredCapabilities );
        } else {
            WebDriverExtender driver;
            switch (browserType) {
                case CHROME:
                    driver = new ChromeWebDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxWebDriver();
                    break;
                case SAFARI:
                    driver = new SafariWebDriver();
                    break;
                case EDGE:
                    driver = new EdgeWebDriver();
                    break;
                default:
                    throw new IllegalStateException("Unknown browser type! Please check your configuration");
            }
            System.setProperty( driver.getDriverName(), AppConfig.getInstance().getDriverPath( browserType ) );
            return driver;
        }
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
