package pl.dev4lazy.web_drivers;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeWebDriver extends EdgeDriver implements WebDriverExtender {

    public static final String DRIVER_NAME = "webdriver.edge.driver";

    @Override
    public String getDriverName() {
        return DRIVER_NAME;
    }

}
