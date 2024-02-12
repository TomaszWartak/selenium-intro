package pl.dev4lazy.configuration;

public class AppProperties {

    public static String getApplicationUrl() {
        return PropertiesWrapper.getProperties().getProperty("app.url");
    }
}
