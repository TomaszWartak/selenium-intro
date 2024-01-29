package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.*;

/*
Zadanie 9.1
Uwaga:
Zadanie 9.1 nie jest zawarte w lekcjach odnoszących się do budowy frameworka - jest to zadanie dodatkowe.
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
	1. Stwórz nową klasę testową, która będzie rozszerzać klasę TestBase.
	2. Przejdź do strony głównej sklepu.
	3. Przejdź do podstrony rybek (Fish).
	4. Kliknij w ID rybki Angel Fish.
	5. Dodaj Small Angelfish do koszyka.
	6. Kliknij w przycisk Proceed to checkout.
	7. Potwierdź, że nastąpiło przekierowanie do strony logowania i wyświetlił się komunikat You must sign on before
	attempting to check out. Please sign on and try checking out again.
Stosuj się do poprawnego nazewnictwa oraz stosuj Page Object Pattern.

 */
public class CheckoutTests extends TestsBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        // 2. Przejdź do strony głównej sklepu.
        LandingPage landingPage = new LandingPage();
        landingPage.clickEnterTheStoreLink();

        // 3. Przejdź do podstrony rybek (Fish).
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickFishLink();

        // 4. Kliknij w ID rybki Angel Fish.
        FishCatalogPage fishCatalogPage = new FishCatalogPage();
        fishCatalogPage.clickAngelFishIdLink();

        // 5. Dodaj Small Angelfish do koszyka.
        AngelFishCatalogPage angelFishCatalogPage = new AngelFishCatalogPage();
        angelFishCatalogPage.clickSmallAngelFishAddToCartLink();

        // 6. Kliknij w przycisk Proceed to checkout.
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickProceedToCheckoutLink();

        // 7. Potwierdź, że nastąpiło przekierowanie do strony logowania i wyświetlił się komunikat:
        // You must sign on before attempting to check out. Please sign on and try checking out again.
        LoginPage loginPage = new LoginPage();
        loginPage.isFailedMessageDisplayed(
                "You must sign on before attempting to check out.  "+
                "Please sign on and try checking out again."
        );
    }
}
