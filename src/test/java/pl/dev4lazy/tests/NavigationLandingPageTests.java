package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.LandingPage;

public class NavigationLandingPageTests extends TestsBase {

    @Test
    public void enterLandingPage() {
        new LandingPage().navigateTo();
    }

    @Test
    public void enterTopMenuPageFromLandingPage() {
        LandingPage landingPage = new LandingPage();
        landingPage.navigateTo();
        landingPage.clickEnterTheStoreLink();
    }

}
