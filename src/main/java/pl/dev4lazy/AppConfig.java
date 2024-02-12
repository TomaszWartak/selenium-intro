package pl.dev4lazy;

import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.configuration.LocalWebDriverProperties;
import pl.dev4lazy.utils.SystemInfo;

public class AppConfig{

    static final String WIN_CHROME_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    static final String MAC_CHROME_DRIVER_PATH = "/usr/local/bin/chromedriver";
    static final String WIN_FIREFOX_DRIVER_PATH = "C:\\drivers\\geckodriver.exe";
    static final String MAC_FIREFOX_DRIVER_PATH = "/usr/local/bin/geckodriver";
    static final String MAC_SAFARI_DRIVER_PATH = "/usr/bin/safaridriver";

    private static AppConfig instance;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public static String getDriverPath( BrowserType browserType ) {
        switch (browserType) {
            case CHROME:
                return LocalWebDriverProperties.getChromeWebDriverLocation();
            case FIREFOX:
                return LocalWebDriverProperties.getFirefoxWebDriverLocation();
            case SAFARI:
                return LocalWebDriverProperties.getSafariWebDriverLocation();
            default: {
                throw new IllegalStateException("Unsupported browser: "+browserType.name() );
            }
        }
    }

}
