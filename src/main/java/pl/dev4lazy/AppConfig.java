package pl.dev4lazy;

import pl.dev4lazy.browser_factory.BrowserType;
import pl.dev4lazy.utils.SystemInfo;

public class AppConfig{

    static final String WIN_CHROME_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    static final String MAC_CHROME_DRIVER_PATH = "/usr/local/bin/chromedriver";
    static final String WIN_FIREFOX_DRIVER_PATH = "C:\\drivers\\geckodriver.exe";
    static final String MAC_FIREFOX_DRIVER_PATH = "/usr/local/bin/geckodriver";

    private static AppConfig instance;

    private static String chromeDriverPath = "";
    private static String fireFoxDriverPath = "";
    private static String safariDriverPath ="";

    private AppConfig() {
        // todo w loadFromFole powinno nastąpić wczytanie ścieżek do driverów...
        loadFromFile();
        // todo ale nie następuje więc trzeba ustawić ręcznie

        chromeDriverPath = getDriverPath( BrowserType.CHROME );
        fireFoxDriverPath = getDriverPath( BrowserType.FIREFOX );
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    private static String getDriverPath( BrowserType browserType ) {
        switch (SystemInfo.getOSId()) {
            case SystemInfo.MAC_OS_ID: {
                switch (browserType) {
                    case CHROME:
                        return MAC_CHROME_DRIVER_PATH;
                    case FIREFOX:
                        return MAC_FIREFOX_DRIVER_PATH;
                    default: {
                        throw new IllegalStateException("Unsupported browser: "+browserType.name() );
                    }
                }
            }
            case SystemInfo.WIN_OS_ID: {
                switch (browserType) {
                    case CHROME:
                        return WIN_CHROME_DRIVER_PATH;
                    case FIREFOX:
                        return WIN_FIREFOX_DRIVER_PATH;
                    default: {
                        throw new IllegalStateException("Unsupported browser: "+browserType.name() );
                    }
                }
            }
            default: {
                throw new IllegalStateException("Unsupported OS");
            }
        }
    }

   public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    private static void setChromeDriverPath(String driverPath) {
        AppConfig.chromeDriverPath = driverPath;
    }

    public static String getFireFoxDriverPath() {
        return fireFoxDriverPath;
    }

    private static void setFireFoxDriverPath(String driverPath) {
        AppConfig.fireFoxDriverPath = driverPath;
    }

    public static String getSafariDriverPath() {
        return safariDriverPath;
    }

    private void loadFromFile() {
        // TODO
    }

    private void saveToFile() {
        // TODO
    }


}
