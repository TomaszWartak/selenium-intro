package pl.dev4lazy.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", xxx "C:/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", xxx "C:/drivers/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
