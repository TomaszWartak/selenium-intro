package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

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
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {
//        Kliknij w link Enter the Store
        clickEnterTheStoreLink();
//        Kliknij w link Sign In
        clickSignInLink();
//        Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
        processIncorrectLoginAndPassword();
//        Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
        checkSignonFailedMessage();
    }

    private void clickEnterTheStoreLink() {
        WebElement enterTheStoreLink = driver.findElement(
                By.xpath( new Locator().anyA().withInnerText("Enter the Store").get() )
        );
        enterTheStoreLink.click();
    }

    private void clickSignInLink() {
        WebElement signInLink = driver.findElement(
                By.xpath( new Locator().anyA().withInnerText("Sign In").get() )
        );
        signInLink.click();
    }

    private void processIncorrectLoginAndPassword() {
        processLoginAndPassword("chuj", "chujp");
    }

    private void processLoginAndPassword(String login, String password) {
        WebElement userNameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement signOnInput = driver.findElement(By.name("signon"));
        userNameInput.clear();
        userNameInput.sendKeys(login);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        signOnInput.click();
    }

    private void checkSignonFailedMessage() {
        WebElement messageLi = driver.findElement(
                By.xpath( new Locator().anyLi().withInnerText("Invalid username or password.  Signon failed.").get() )
        );
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword(){

        clickEnterTheStoreLink();

        clickSignInLink();

        processCorrectLoginAndPassword();

        checkBannerAfterLoginLoginIsDisplayed();
    }

    private void checkBannerAfterLoginLoginIsDisplayed() {
        WebElement bannerAfterLoginLogo=driver.findElement( By.id("Banner"));
        assertTrue(bannerAfterLoginLogo.isDisplayed());
    }

    private void processCorrectLoginAndPassword() {
        processLoginAndPassword("j2ee", "j2ee");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}