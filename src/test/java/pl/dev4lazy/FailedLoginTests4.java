package pl.dev4lazy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.LandingPage;
import pl.dev4lazy.page_objects.LoginPage;
import pl.dev4lazy.page_objects.TopMenuPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

/*
Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
Kliknij w link Sign In
Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
 */
public class FailedLoginTests4 {
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
        LandingPage landingPage = new LandingPage( driver );
        landingPage.clickEnterTheStoreLink();
//        Kliknij w link Sign In
        TopMenuPage topMenuPage = new TopMenuPage( driver );
        topMenuPage.clickSignInLink();
//        Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
        LoginPage loginPage = new LoginPage( driver );
        processIncorrectLoginAndPassword( loginPage );
//        Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
        assertTrue( loginPage.isSignOnFailedMessageDisplayed( "Invalid username or password. Signon failed." ) );
    }

    private void processIncorrectLoginAndPassword( LoginPage loginPage ) {
        loginPage.processLoginAndPassword("chuj", "chujp");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword(){

        LandingPage landingPage = new LandingPage( driver );
        landingPage.clickEnterTheStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage( driver );
        topMenuPage.clickSignInLink();

        LoginPage loginPage = new LoginPage( driver );
        processCorrectLoginAndPassword( loginPage );

        assertTrue(loginPage.isBannerAfterLoginDisplayed());
    }
    private void processCorrectLoginAndPassword( LoginPage loginPage ) {
        loginPage.processLoginAndPassword("j2ee", "j2ee");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}