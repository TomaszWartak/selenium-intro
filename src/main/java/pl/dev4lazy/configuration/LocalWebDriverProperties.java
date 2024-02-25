package pl.dev4lazy.configuration;

import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.utils.SystemInfo;

public class LocalWebDriverProperties {

    public static String getChromeWebDriverLocation() {
        String property = "";
        switch (SystemInfo.getOSId()) {
            case SystemInfo.MAC_OS_ID:
                property = PropertiesContainer.getProperties().getProperty("chrome.driver.location.mac");
                break;
            case SystemInfo.WIN_OS_ID:
                property = PropertiesContainer.getProperties().getProperty("chrome.driver.location.windows");
                break;
            default: {
                throw new IllegalStateException("Unsupported OS");
            }
        }
        return property;    }

    public static String getFirefoxWebDriverLocation() {
        String property = "";
        switch (SystemInfo.getOSId()) {
            case SystemInfo.MAC_OS_ID:
                property = PropertiesContainer.getProperties().getProperty("firefox.driver.location.mac");
                break;
            case SystemInfo.WIN_OS_ID:
                property = PropertiesContainer.getProperties().getProperty("firefox.driver.location.windows");
                break;
            default: {
                throw new IllegalStateException("Unsupported OS");
            }
        }
        return property;
    }

    public static String getSafariWebDriverLocation() {
        String property = "";
        switch (SystemInfo.getOSId()) {
            case SystemInfo.MAC_OS_ID:
                property = PropertiesContainer.getProperties().getProperty("safari.driver.location.mac");
                break;
            default: {
                throw new IllegalStateException("Unsupported OS");
            }
        }
        return property;
    }
}
