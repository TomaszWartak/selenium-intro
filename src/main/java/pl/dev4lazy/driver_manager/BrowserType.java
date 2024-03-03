package pl.dev4lazy.driver_manager;

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("edge"),
    SAFARI("safari");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
