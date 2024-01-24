package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	1. Przejdź na stronę dynamic controls (https://theinternet.przyklady.javastart.pl/dynamic_controls)
	2. Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
	3. Naciśnij na przycisk Remove
	4. Sprawdź, że po jakimś czasie pojawi się tekst It's gone!
	5. Naciśnij na przycisk Add
	6. Sprawdź, że checkbox jest odznaczony oraz widoczny
Inne wymagania:
	• Nazwa klasy testowej: ExplicitWaitTests
	• Nazwa metody testowej: waitForPresenceOfTheElement
	• Użyj implementacji WebDriverWait do czekania
	• Test powinien używać co najmniej dwóch różnych warunków (ExpectedConditions) na oczekiwanie. Aby uniknąć duplikacji w kodzie do tego celu zaimplementuj dodatkowo klasę o nazwie WaitUntil, która będzie dostarczała metod na czekanie.

 */
public class _8_2_ExplicitWaitTests {

    final String WIN_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String MAC_DRIVER_PATH = "/usr/local/bin/chromedriver";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/dynamic_controls";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", WIN_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }
    @Test
    public void waitForPresenceOfTheElement() {
//        2. Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
        WebElement checkbox = driver.findElement( By.id( "checkbox" ) );
        assertFalse( checkbox.isSelected() );
        assertTrue( checkbox.isDisplayed() );

//        3. Naciśnij na przycisk Remove
        WebElement removeButton = driver.findElement(
                By.xpath( new Locator().button().withInnerText("Remove").get() )
        );
        removeButton.click();

//        4. Sprawdź, że po jakimś czasie pojawi się tekst It's gone!
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        WebElement messageP = wait.until( driver -> driver.findElement( By.id("message") ) );
        assertEquals( messageP.getText(), "It's gone!" );

//        5. Naciśnij na przycisk Add
        WebElement addButton = driver.findElement(
                By.xpath( new Locator().button().withInnerText("Add").get() )
        );
        addButton.click();

//        6. Sprawdź, że checkbox jest odznaczony oraz widoczny
        checkbox = wait.until( driver -> driver.findElement( By.id("checkbox") ) );
        assertFalse( checkbox.isSelected() );
        assertTrue( checkbox.isDisplayed() );
    }

    @Test
    public void waitForPresenceOfTheElement2() {
//        2. Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
        WebElement checkbox = driver.findElement( By.id( "checkbox" ) );
        assertFalse( checkbox.isSelected() );
        assertTrue( checkbox.isDisplayed() );

//        3. Naciśnij na przycisk Remove
        WebElement removeButton = driver.findElement(
                By.xpath( new Locator().button().withInnerText("Remove").get() )
        );
        removeButton.click();

//        4. Sprawdź, że po jakimś czasie pojawi się tekst It's gone!
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement messageP = wait.until( driver -> driver.findElement( By.id("message") ) );
        assertEquals( messageP.getText(), "It's gone!" );

//        5. Naciśnij na przycisk Add
        WebElement addButton = driver.findElement(
                By.xpath( new Locator().button().withInnerText("Add").get() )
        );
        addButton.click();

//        6. Sprawdź, że checkbox jest odznaczony oraz widoczny
        checkbox = wait.until( driver -> driver.findElement( By.id("checkbox") ) );
        assertFalse( checkbox.isSelected() );
        assertTrue( checkbox.isDisplayed() );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

