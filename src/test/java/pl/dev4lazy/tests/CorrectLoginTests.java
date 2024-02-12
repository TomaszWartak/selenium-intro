package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.FooterPage;
import pl.dev4lazy.page_objects.LoginPage;
import pl.dev4lazy.tests.TestsBase;

import static org.testng.Assert.assertTrue;

public class CorrectLoginTests extends TestsBase {

    private final String CORRECT_LOGIN = "j2ee";
    private final String CORRECT_PASSWORD = "j2ee";

    @Test
    public void asUserLoginUsingValidLoginAndPassword(){
/*
        new LandingPage().clickEnterTheStoreLink();

        new TopMenuPage().clickSignInLink();*/

        LoginPage loginPage = new LoginPage();
        loginPage.navigateTo();
        loginPage.processLoginAndPassword( CORRECT_LOGIN, CORRECT_PASSWORD );

        assertTrue( new FooterPage().isBannerAfterLoginDisplayed() );
    }

}