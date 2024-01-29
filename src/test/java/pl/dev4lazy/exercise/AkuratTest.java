package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import static org.testng.Assert.*;


public class AkuratTest {

    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "http://akurat.pl/produkt/nowy-lepszy-swiat/";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH );
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }
    @Test
    public void akurat() {
        WebElement quantityInput = driver.findElement(
                By.xpath(
                    new Locator()
                            .anyDescendant()
                                .withName( "quantity")
                            .get()
                )
        );
        quantityInput.click();
        quantityInput.sendKeys( "2" );
        assertEquals( quantityInput.getText(), "2" );
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
