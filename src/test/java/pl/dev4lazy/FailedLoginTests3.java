package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import java.time.Duration;

/*
Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
Kliknij w link Sign In
Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
 */
public class FailedLoginTests3 {
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
//        Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
        driver.navigate().to( APP_URL );
    }

    @Test
    public void test() {
//        Kliknij w link Enter the Store
        enterTheStoreClick();
//        Kliknij w link Sign In
        signInClick();
//        Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
        processIncorrectLoginAndPassword();
//        Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
        checkSignonFailedMessage();
    }

    private void checkSignonFailedMessage() {
        WebElement messageLi = driver.findElement(
                By.xpath( new Locator().li().withInnerText("Invalid username or password.  Signon failed.").get() )
        );
    }

    private void processIncorrectLoginAndPassword() {
        WebElement userNameInput = driver.findElement(
                By.xpath( new Locator().input().withName("username").get() )
        );
        WebElement passwordInput = driver.findElement(
                By.xpath( new Locator().input().withName("password").get() )
        );
        WebElement signOnInput = driver.findElement(
                By.xpath( new Locator().input().withName("signon").get() )
        );
        userNameInput.sendKeys( "chuj");
        passwordInput.sendKeys( "chujp");
        signOnInput.click();
    }

    private void signInClick() {
        WebElement signInLink = driver.findElement(
                By.xpath( new Locator().a().withInnerText("Sign In").get() )
        );
        signInLink.click();
    }

    private void enterTheStoreClick() {
        WebElement enterTheStoreLink = driver.findElement(
                By.xpath( new Locator().a().withInnerText("Enter the Store").get() )
        );
        enterTheStoreLink.click();
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}