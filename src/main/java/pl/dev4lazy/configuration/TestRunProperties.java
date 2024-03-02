package pl.dev4lazy.configuration;

import pl.dev4lazy.browser_factory.BrowserType;

public class TestRunProperties {

    private TestRunProperties() {
        throw new IllegalStateException("Utility class");
    }

    public static String getGridUrl() {
        return PropertiesContainer.getProperties().getProperty("grid.url");
    }

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf( PropertiesContainer.getProperties().getProperty("browser") );
    }

    public static void setBrowserToRun( String browser ) {
        if (browser!=null) {
            PropertiesContainer.getProperties().setProperty("browser", browser);
        }
    }

    public static boolean isRemoteRun(){
        return Boolean.parseBoolean( PropertiesContainer.getProperties().getProperty("remoteRun") );
    }
}
