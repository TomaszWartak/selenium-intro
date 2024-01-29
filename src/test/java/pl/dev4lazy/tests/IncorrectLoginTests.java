package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.LandingPage;
import pl.dev4lazy.page_objects.LoginPage;
import pl.dev4lazy.page_objects.TopMenuPage;

import static org.testng.Assert.assertTrue;

/*
Wejdź na stronę http://przyklady.javastart.pl/jpetstore/
Kliknij w link Sign In
Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
 */
public class IncorrectLoginTests extends TestsBase {

    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {
//        Kliknij w link Enter the Store
        LandingPage landingPage = new LandingPage();
        landingPage.clickEnterTheStoreLink();
//        Kliknij w link Sign In
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickSignInLink();
//        Na stronie logowania podając nieprawidłowy login i hasło spróbuj się zalogować
        LoginPage loginPage = new LoginPage();
        processIncorrectLoginAndPassword( loginPage );
//        Test powinien skończyć się sprawdzeniem czy komunikat „Invalid username or password. Signon failed.” został wyświetlony.
        assertTrue( loginPage.isFailedMessageDisplayed( "Invalid username or password. Signon failed." ) );
    }

    private void processIncorrectLoginAndPassword( LoginPage loginPage ) {
        loginPage.processLoginAndPassword("chuj", "chujp");
    }

}