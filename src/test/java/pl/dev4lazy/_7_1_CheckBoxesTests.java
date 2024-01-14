package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
        WebElement checkbox1 = driver.findElement( By.xpath( "//[@id='checkboxes']" ) );
        checkbox1.sendKeys( "Dupa blada...");
        assertEquals( checkbox1.getAttribute( "value"), "Dupa blada...");
        checkbox1.clear();
        assertEquals( checkbox1.getAttribute( "value"), "");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
