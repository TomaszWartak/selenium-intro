package pl.dev4lazy.waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.dev4lazy.driver_manager.DriverManager;

import java.time.Duration;
import java.util.List;

public class Waiter {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait( DriverManager.getWebDriver(), Duration.ofSeconds(10) );
    }

    public static void untilElementIsVisible(WebElement webElement ) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf( webElement ));
    }

    public static void untilElementsAreVisible(List<WebElement> webElementList ) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements( webElementList ));
    }

    public static void untilElementIsClickable(WebElement webElement ) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until( ExpectedConditions.elementToBeClickable( webElement ));
    }
}
