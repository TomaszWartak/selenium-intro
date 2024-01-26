package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
Kliknij w link Sign In
Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
 */
public class FailedLoginTests2 {
    final String WIN_DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String MAC_DRIVER_PATH = "/usr/local/bin/chromedriver";
    final String APP_URL = "http://przyklady.javastart.pl/jpetstore/";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        String driverPath = MAC_DRIVER_PATH;
//        String driverPath = WIN_DRIVER_PATH;
        System.setProperty("webdriver.chrome.driver", driverPath );
        driver = new ChromeDriver();
//      Ustawienie Implicit Wait na 10 sekund
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
        driver.navigate().to( APP_URL );
    }

    @Test
    public void test() {
//Kliknięcie w link "Enter the Store"
        driver.findElement(By.cssSelector("#Content a")).click();
//Kliknięcie w link "Sign In"
        driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']")).click();
//Wpisanie w polu Username wartośći "NotExistingLogin"
        driver.findElement(By.name("username")).sendKeys("NotExistingLogin");
//Wpisanie w polu Password wartości "NotProperPassword"
        driver.findElement(By.name("password")).sendKeys("NotProperPassword");
//Kliknięcie w przycisk Login
        driver.findElement(By.name("signon")).click();
//Sprawdzenie czy na stronie pojawił się komunikat "Invalid username or password. Signon failed."
        // przez sprawdzenie jaki tekst wyświetli się w elemencie
        assertEquals(driver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText(), "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}