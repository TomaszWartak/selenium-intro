package pl.dev4lazy.configuration;

import pl.dev4lazy.browser_factory.BrowserType;

public class TestRunProperties {

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf( PropertiesContainer.getProperties().getProperty("browser") );
    }

    public static boolean isRemoteRun(){
        return Boolean.parseBoolean( PropertiesContainer.getProperties().getProperty("remoteRun") );
    }
}
