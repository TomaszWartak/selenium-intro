package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
public class LocatorsTest {
    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "http://przyklady.javastart.pl/jpetstore/actions/Catalog.action";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Test
    public void testLogoIsPresent() {
        driver.navigate().to( APP_URL );
        assertTrue( driver.findElement( By.id( "LogoContent") ).isDisplayed() );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
