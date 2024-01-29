package pl.dev4lazy.exercise;

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
public class FailedLoginTests {
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
//        Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
        driver.navigate().to( APP_URL );
    }

    @Test
    public void test() {
//        Kliknij w link Sign In
        WebElement enterTheStoreLink = driver.findElement(
                By.xpath( new Locator().anyA().withInnerText("Enter the Store").get() )
        );
        enterTheStoreLink.click();
        Wait<WebDriver> signInLinkWait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        WebElement signInLink = signInLinkWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath( new Locator().anyA().withInnerText("Sign In").get() )
                )
        );
        signInLink.click();
//        Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
        Wait<WebDriver> userNameInputWait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        WebElement userNameInput = userNameInputWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath( new Locator().anyInput().withName("username").get() )
                )
        );
        WebElement passwordInput = driver.findElement(
                By.xpath( new Locator().anyInput().withName("password").get() )
        );
        WebElement signOnInput = driver.findElement(
                By.xpath( new Locator().anyInput().withName("signon").get() )
        );
        userNameInput.sendKeys( "chuj");
        passwordInput.sendKeys( "chujp");
        signOnInput.click();
//        Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
        Wait<WebDriver> messageLiWait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        WebElement messageLi = messageLiWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath( new Locator().anyLi().withInnerText("Invalid username or password.  Signon failed.").get() )
                )
        );

    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}