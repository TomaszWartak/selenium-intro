package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class IncorrectLoginTests extends TestsBase {

    private final String WRONG_LOGIN = "chuj";
    private final String WRONG_PASSWORD = "chujp";

    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {

        LoginPage loginPage = new LoginPage();
        loginPage.navigateTo();
        loginPage.processLoginAndPassword( WRONG_LOGIN, WRONG_PASSWORD );

        assertTrue( loginPage.isFailedMessageDisplayed( "Invalid username or password. Signon failed." ) );
    }

}