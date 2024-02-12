package pl.dev4lazy.tests;

import org.testng.annotations.Test;
import pl.dev4lazy.page_objects.*;

public class CheckoutTests extends TestsBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        // 3. Przejdź do podstrony rybek (Fish).
        FishCatalogPage fishCatalogPage = new FishCatalogPage();
        fishCatalogPage.navigateTo();

        // 4. Kliknij w ID rybki Angel Fish.
        fishCatalogPage.clickAngelFishIdLink();

        // 5. Dodaj Small Angelfish do koszyka.
        new AngelFishCatalogPage().clickSmallAngelFishAddToCartLink();

        // 6. Kliknij w przycisk Proceed to checkout.
        new ShoppingCartPage().clickProceedToCheckoutLink();

        // 7. Potwierdź, że nastąpiło przekierowanie do strony logowania i wyświetlił się komunikat:
        // You must sign on before attempting to check out. Please sign on and try checking out again.
        new LoginPage().isFailedMessageDisplayed(
                "You must sign on before attempting to check out.  "+
                "Please sign on and try checking out again."
        );
    }
}
