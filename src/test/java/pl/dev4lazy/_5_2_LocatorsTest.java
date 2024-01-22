package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
Stwórz lokatory XPath oraz CSS dla poniższych elementów ze strony http://przyklady.javastart.pl/jpetstore/actions/Catalog.action. 
Do tworzenia i testowania selektorów użyj zakładki Elements z panelu deweloperskiego przeglądarki Chrome.
Lista elementów do pokrycia:
	1. Logo w lewym górnym rogu strony głównej,
	2. Przycisk koszyk,
	3. Link do strony logowania,
	4. Link do strony pomocy,
	5. Pole wyszukiwarki,
	6. Przycisk Search,
	7. Link Fish z górnego menu,
	8. Link Dogs z górnego menu,
	9. Link Reptiles z górnego menu,
	10. Link Cats z górnego menu,
	11. Link Birds z górnego menu,
	12. Link Fish z bocznego menu,
	13. Link Dogs z bocznego menu,
	14. Link Reptiles z bocznego menu,
	15. Link Cats z bocznego menu,
	16. Link Birds z bocznego menu,
	17. Główny obraz strony,
	18. Hiperłącze do strony www.mybaits.org.

 */
public class _5_2_LocatorsTest {
    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "https://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }

    @Test
    public void testLogoIsPresent() {
        assertTrue( driver.findElement( By.id( "LogoContent") ).isDisplayed() );
    }

    /* Zadanie 5.2
       Wykorzystując poznane dobre praktyki wybierz lokatory dla poniższych elementów ze strony
       http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=. \
       Do wyboru i testowania selektorów użyj zakładki Elements z panelu deweloperskiego przeglądarki Chrome.

        Lista elementów do pokrycia:
            1. Edytowalne pole User ID
            2. Edytowalne pole New Password
            3. Edytowalne pole Repeat Password
            4. Lista wybieralna Language Preferences
            5. Lista wybieralna Favourite Category
            6. Przycisk edytowalny typu checkbox Enable MyList
            7. Przycisk edytowalny typu checkbox Enable MyBanner
            8. Przycisk Save Account Information
     */

    @Test
    public void locators_Userid() {
        WebElement webElement = driver.findElement( By.xpath( "//input[@name='username']") );
        driver.findElement( By.cssSelector( "input[name='username']"));
    }

    @Test
    public void locators_UserId2() {
        WebElement webElement = driver.findElement(
                By.xpath(
                        new Locator()
                                .anyDescendant()
                                .withTag("input")
                                .withAttributeValue( "name", "username" )
                                .get()
                )
        );
    }

    @Test
    public void locators_LanguagePreferences() {
        WebElement webElement = driver.findElement(
                By.xpath(
                        new Locator()
                                .anyDescendant()
                                    .withTag( "select")
                                    .withName( "account.languagePreference")
                                .get()
                )
        );
    }

    @Test
    public void locators_NewPassword() {
        WebElement webElement = driver.findElement(
                By.xpath(
                        new Locator()
                                .anyDescendant()
                                    .withTag( "input")
                                    .withName( "password")
                                .get()
                )
        );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
