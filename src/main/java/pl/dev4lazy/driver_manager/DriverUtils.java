package pl.dev4lazy.driver_manager;

public class DriverUtils {

    private DriverUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }
    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }

}
