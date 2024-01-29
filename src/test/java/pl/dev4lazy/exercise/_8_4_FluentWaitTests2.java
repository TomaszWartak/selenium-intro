package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/*
Zadanie 8.4:
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
	1. Przejdź na stronę dynamic_loading/2
	2. Naciśnij na przycisk Start
	3. Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
Inne wymagania:
	• Nazwa klasy testowej: FluentWaitTests2
	• Nazwa metody testowej: fluentWaitWithExceptionTest
	• Użyj implementacji FluentWait do czekania
 */
public class _8_4_FluentWaitTests2 {

    final String WIN_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String MAC_DRIVER_PATH = "/usr/local/bin/chromedriver";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/dynamic_loading/2";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", WIN_DRIVER_PATH);
        driver = new ChromeDriver();
//   1. Przejdź na stronę dynamic_loading/2
        driver.navigate().to( APP_URL );
    }

    @Test
    public void fluentWaitTest() {
//   2. Naciśnij na przycisk Start
        WebElement startButton = driver.findElement(
                By.xpath( new Locator().anyButton().withInnerText("Start").get() )
        );
        startButton.click();

//   3. Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement helloWorld = wait.until(
                ExpectedConditions.visibilityOfElementLocated( By.xpath(
                        new Locator().anyDescendant().withInnerText( "Hello World!").get() )
                )
        );
        assertTrue( helloWorld.isDisplayed() );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
