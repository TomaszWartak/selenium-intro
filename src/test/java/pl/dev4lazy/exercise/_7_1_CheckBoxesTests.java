package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import static org.testng.Assert.*;

/*
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
	1. Przejdź na stronę checkboxes (https://theinternet.przyklady.javastart.pl/checkboxes)
	2. Sprawdź, że po wejściu na stronę checkbox 1 jest odznaczony, zaś checkbox 2 jest zaznaczony
	3. Zaznacz checkbox 1, odznacz checkbox 2
	4. Sprawdź, że checkbox 1 jest zaznaczony, zaś checkbox 2 jest odznaczony
Inne wymagania:
	• Nazwa klasy testowej: CheckBoxesTests

Nazwa metody testowej: checkboxesTest
 */
public class _7_1_CheckBoxesTests {

    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/checkboxes";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH );
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }

    @Test
    public void checkboxesTest() {
        WebElement checkbox1 = driver.findElement( By.xpath( "//form[@id='checkboxes']/input[1]" ) );
        WebElement checkbox2 = driver.findElement( By.xpath( "//form[@id='checkboxes']/input[2]" ) );

        // 2. Sprawdź, że po wejściu na stronę checkbox 1 jest odznaczony, zaś checkbox 2 jest zaznaczony
        assertFalse( checkbox1.isSelected() );
        assertTrue( checkbox2.isSelected() );

        // 3. Zaznacz checkbox 1, odznacz checkbox 2
        checkbox1.click();
        checkbox2.click();

        // 4. Sprawdź, że checkbox 1 jest zaznaczony, zaś checkbox 2 jest odznaczony
        assertTrue( checkbox1.isSelected() );
        assertFalse( checkbox2.isSelected() );
    }

    @Test
    public void checkboxesTest2() {
        WebElement checkbox1 = driver.findElement(
                By.xpath( new Locator()
                        .directDescendant()
                            .withTag( "input")
                            .first()
                        .of().anyDescendant()
                            .withTag( "form ")
                            .withId( "checkboxes")
                        .get()
                )
        );
        WebElement checkbox2 = driver.findElement(
                By.xpath( new Locator()
                        .directDescendant()
                            .withTag( "input")
                            .second()
                        .of().anyDescendant()
                            .withTag( "form ")
                            .withId( "checkboxes")
                        .get()
                )
        );

        // 2. Sprawdź, że po wejściu na stronę checkbox 1 jest odznaczony, zaś checkbox 2 jest zaznaczony
        assertFalse( checkbox1.isSelected() );
        assertTrue( checkbox2.isSelected() );

        // 3. Zaznacz checkbox 1, odznacz checkbox 2
        checkbox1.click();
        checkbox2.click();

        // 4. Sprawdź, że checkbox 1 jest zaznaczony, zaś checkbox 2 jest odznaczony
        assertTrue( checkbox1.isSelected() );
        assertFalse( checkbox2.isSelected() );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
