package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.MainPage;

public class NavigationMainPageTests extends TestsBase {

    @Test
    public void enterLoginPageFromTopMenuPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigateTo();
        mainPage.clickSignInLink();
    }

    @Test
    public void enterFishCatalogFromTopMenuPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigateTo();
        mainPage.clickFishLinkFromTopMenu();
    }

    @Test
    public void enterDogsCatalogFromTopMenuPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigateTo();
        mainPage.clickDogsLinkFromTopMenu();
    }

    @Test
    public void enterCatsCatalogFromTopMenuPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigateTo();
        mainPage.clickCatsLinkFromTopMenu();
    }

    @Test
    public void enterReptilesCatalogFromTopMenuPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigateTo();
        mainPage.clickReptilesLinkFromTopMenu();
    }

    @Test
    public void enterBirdsCatalogFromTopMenuPage() {
        MainPage mainPage = new MainPage();
        mainPage.navigateTo();
        mainPage.clickBirdsLinkFromTopMenu();
    }

}
