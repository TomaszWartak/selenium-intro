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
//      todo usuń uzycie asercji w page objecie   loginPage.assertThatWarningIsDisplayed( "Invalid username or password. Signon failed." );
         assertTrue( loginPage.isFailedMessageDisplayed( "Invalid username or password. Signon failed." ) );
    }
    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassword_negative_test_verification() {

        LoginPage loginPage = new LoginPage();
        loginPage.navigateTo();
        loginPage.processLoginAndPassword( WRONG_LOGIN, WRONG_PASSWORD );
//      todo usuń uzycie asercji w page objecie   loginPage.assertThatWarningIsDisplayed( "XXX" );
         assertTrue( !loginPage.isFailedMessageDisplayed( "XXX" ) );
    }

}