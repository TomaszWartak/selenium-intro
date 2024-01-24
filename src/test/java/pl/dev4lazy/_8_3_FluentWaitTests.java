package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import java.time.Duration;

import static org.testng.Assert.*;
/*
    Zadanie 8.3:
    Stwórz test automatyczny na podstawie poniższego scenariusza testowego:

    1. Przejdź na stronę dynamic_loading/1 (https://theinternet.przyklady.javastart.pl/dynamic_loading/1)
    2. Sprawdź, że po wejściu na stronę tekst Hello World! jest niewidoczny!
    3. Naciśnij na przycisk Start
    4. Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
    Uwaga: Przed przystąpieniem do pracy sprawdź jak działa funkcjonalność na stronie. Tekst Hello World! jest dostępny na stronie cały czas, pomimo tego, że go nie widać!

    Inne wymagania:

    Nazwa klasy testowej: FluentWaitTests
    Nazwa metody testowej: fluentWaitTest
    Użyj implementacji FluentWait do czekania
 */
public class _8_3_FluentWaitTests {

    final String WIN_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String MAC_DRIVER_PATH = "/usr/local/bin/chromedriver";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/dynamic_loading/1";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", WIN_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }

    @Test
    public void fluentWaitTest() {
//   2. Sprawdź, że po wejściu na stronę tekst Hello World! jest niewidoczny!
        WebElement helloWorldH4 = driver.findElement( By.id( "finish" ) );
        assertFalse( helloWorldH4.isDisplayed() );

//   3. Naciśnij na przycisk Start
        WebElement startButton = driver.findElement(
                By.xpath( new Locator().button().withInnerText("Start").get() )
        );
        startButton.click();

//   4. Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        helloWorldH4 = wait.until(
                ExpectedConditions.visibilityOfElementLocated( By.id( "finish" ) )
        );
        assertTrue( helloWorldH4.isDisplayed() );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

