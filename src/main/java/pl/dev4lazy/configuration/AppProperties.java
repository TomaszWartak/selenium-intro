package pl.dev4lazy.configuration;

public class AppProperties {

    private AppProperties() {
        throw new IllegalStateException("Utility class");
    }
    public static String getApplicationUrl() {
        return PropertiesContainer.getProperties().getProperty("app.url");
    }

}
