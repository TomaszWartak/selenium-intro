package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebElementsTests {
    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "http://przyklady.javastart.pl/test/full_form.html";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH );
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }

    @Test
    public void checkFillingAndClearUserNameInput() {
        WebElement userNameInput = driver.findElement( By.id( "username" ) );
        userNameInput.sendKeys( "Dupa blada...");
        assertEquals( userNameInput.getAttribute( "value"), "Dupa blada...");
        userNameInput.clear();
        assertEquals( userNameInput.getAttribute( "value"), "");
    }

    @Test
    public void getHTML() {
        driver.get("https://Javastart.pl");

        // Pobierz całe drzewo DOM i wyświetl na konsoli
        String domTree = driver.getPageSource();
        System.out.println(domTree);
    }

    @Test void getDOM() {
        // Otwórz stronę internetową
        driver.get("https://javastart.pl");

        // Pobierz korzeń drzewa WebElement dla całej strony
        WebElement rootElement = driver.findElement(By.tagName("html"));

        // Pobierz drzewo obiektów WebElement dla korzenia
        List<WebElement> webElementsTree = rootElement.findElements(By.xpath(".//*"));

        // Wyświetl informacje o każdym elemencie w drzewie
        for (WebElement element : webElementsTree) {
            System.out.println("Tag: " + element.getTagName() + ", Text: " + element.getText());
        }
    }



    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }


}
