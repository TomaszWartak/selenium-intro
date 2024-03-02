package pl.dev4lazy.web_drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver extends FirefoxDriver implements WebDriverExtender {

    public static final String DRIVER_NAME = "webdriver.gecko.driver";

    @Override
    public void quit() {
        // do nothing, cause this method in firefox made exception
    }

    @Override
    public String getDriverName() {
        return DRIVER_NAME;
    }

}
