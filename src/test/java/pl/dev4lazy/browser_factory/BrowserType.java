package pl.dev4lazy.browser_factory;

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
