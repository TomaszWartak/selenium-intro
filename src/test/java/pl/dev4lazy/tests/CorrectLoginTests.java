package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.FooterPage;
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
public class CorrectLoginTests extends TestsBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword(){

        LandingPage landingPage = new LandingPage();
        landingPage.clickEnterTheStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickSignInLink();

        LoginPage loginPage = new LoginPage();
        processCorrectLoginAndPassword( loginPage );

        FooterPage footerPage = new FooterPage();

        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }
    private void processCorrectLoginAndPassword( LoginPage loginPage ) {
        loginPage.processLoginAndPassword("j2ee", "j2ee");
    }

}