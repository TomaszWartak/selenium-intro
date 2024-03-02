package pl.dev4lazy.web_drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver extends ChromeDriver implements WebDriverExtender {

    public static final String DRIVER_NAME = "webdriver.chrome.driver";

    @Override
    public String getDriverName() {
        return DRIVER_NAME;
    }

}
