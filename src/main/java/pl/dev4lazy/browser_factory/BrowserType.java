package pl.dev4lazy.browser_factory;

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    SAFARI("Safari");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
