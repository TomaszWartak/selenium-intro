package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class _3_1_FirstAutomatedTest {
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void myFirstTest() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.name("q")).sendKeys("JavaStart");
        driver.findElement(By.name("q")).submit();
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("JavaStart"));
    }

/*    Napisz nowy test w klasie FirstAutomatedTest o nazwie mySecondTest() zgodny z krokami scenariusza testowego:
    Przejście do strony internetowej: https://selenium.dev/,
    Pobranie tytułu strony,
    Sprawdzenie, że tytuł strony jest równy: „Selenium”.*/

    @Test
    public void mySecondTest() {
        driver.navigate().to("https://selenium.dev/");
        String pageTitle = driver.getTitle();
        assertTrue( pageTitle.equals( "Selenium") );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}