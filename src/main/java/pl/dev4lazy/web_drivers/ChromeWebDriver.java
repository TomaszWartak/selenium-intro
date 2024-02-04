package pl.dev4lazy.web_drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver extends ChromeDriver implements WebDriverExtender {

    public final String driverName = "webdriver.chrome.driver";

    @Override
    public String getDriverName() {
        return driverName;
    }

}
