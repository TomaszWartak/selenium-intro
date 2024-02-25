package pl.dev4lazy.configuration;

public class AppProperties {

    public static String getApplicationUrl() {
        return PropertiesContainer.getProperties().getProperty("app.url");
    }
}
