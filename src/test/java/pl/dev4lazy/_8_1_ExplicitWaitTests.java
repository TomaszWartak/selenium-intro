package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import java.time.Duration;

import static org.testng.Assert.*;


/*
Zadanie 8.1:
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
	1. Przejdź na stronę dynamic controls (https://theinternet.przyklady.javastart.pl/dynamic_controls)
	2. Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
	3. Naciśnij na przycisk Remove
	4. Sprawdź, że po jakimś czasie pojawi się tekst It's gone!
Inne wymagania:
	• Nazwa klasy testowej: ExplicitWaitTests
	• Nazwa metody testowej: waitForDisappearingElement
	• Użyj implementacji WebDriverWait do czekania

 */


public class _8_1_ExplicitWaitTests {

    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/dynamic_controls";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH );
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }
    @Test
    public void test() {
//        2. Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
        WebElement checkbox = driver.findElement( By.id( "checkbox" ) );
        assertFalse( checkbox.isSelected() );
        assertTrue( checkbox.isDisplayed() );
//        3. Naciśnij na przycisk Remove
        WebElement removeButton = driver.findElement(
                By.xpath(
                        new Locator()
                                .anyDescendant()
                                    .withInnerText("Remove")
                                .get()
                )
        );
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        removeButton.click();
//        4. Sprawdź, że po jakimś czasie pojawi się tekst It's gone!
        WebElement messageP = wait.until( driver -> driver.findElement( By.id("message") ) );
        assertEquals( messageP.getText(), "It's gone!" );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
