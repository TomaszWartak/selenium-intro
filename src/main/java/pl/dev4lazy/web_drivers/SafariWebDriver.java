package pl.dev4lazy.web_drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.sql.Driver;

public class SafariWebDriver extends SafariDriver implements WebDriverExtender {

    public final String driverName = "webdriver.safari.driver";

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public void quit() {
        // do nothing, cause this method in safari made exception
    }

}
