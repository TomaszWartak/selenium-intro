package pl.dev4lazy;

import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.configuration.LocalWebDriverProperties;
import pl.dev4lazy.utils.SystemInfo;

public class AppConfig{

    public static final String PROPERTIES_FILE_NAME = "configuration.properties";

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
            case EDGE:
                return LocalWebDriverProperties.getEdgeWebDriverLocation();
            case SAFARI:
                return LocalWebDriverProperties.getSafariWebDriverLocation();
            default: {
                throw new IllegalStateException("Unsupported browser: "+browserType.name() );
            }
        }
    }

}
