package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.dev4lazy.locators.Locator;

import static org.testng.Assert.assertEquals;

/*
Zadanie 7.4:
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:

Przejdź na stronę hovers (https://theinternet.przyklady.javastart.pl/hovers)
Najedź myszką na pierwsze (z lewej) zdjęcie użytkownika
Sprawdź, że po najechaniu myszką pod zdjęciem dostępny jest napis name: user1 oraz że, dla pozostałych dwóch kolejnych zdjęć podpis jest pusty
Wykonaj analogicznie kroki 2 i 3 dla kolejnych zdjęć użytkownika
Inne wymagania:

Nazwa klasy testowej: HoverTests
Nazwa metody testowej: hoverTest
 */
public class _7_4_HoverTests {
    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/hovers";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.navigate().to(APP_URL);
    }

    @Test
    public void hoverTest() {
        //   Najedź myszką na pierwsze (z lewej) zdjęcie użytkownika
        WebElement firstFigureImg = driver.findElement( By.xpath( "//div[@class='example']/div[1]/img") );
        Actions action = new Actions(driver);
        action.moveToElement( firstFigureImg ).perform();

        //   Sprawdź, że po najechaniu myszką pod zdjęciem dostępny jest napis name: user1 oraz że, dla pozostałych dwóch kolejnych zdjęć podpis jest pusty
        WebElement firstFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[1]//h5") );
        assertEquals( firstFigCaptionH5.getText(), "name: user1" );
        WebElement secondFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[2]//h5") );
        assertEquals( secondFigCaptionH5.getText(), "" );
        WebElement thirdFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[3]//h5") );
        assertEquals( thirdFigCaptionH5.getText(), "" );

        //   Wykonaj analogicznie kroki 2 i 3 dla kolejnych zdjęć użytkownika
        WebElement secondFigureImg = driver.findElement( By.xpath( "//div[@class='example']/div[2]/img") );
        action = new Actions(driver);
        action.moveToElement( secondFigureImg ).perform();

        firstFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[1]//h5") );
        assertEquals( firstFigCaptionH5.getText(), "" );
        secondFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[2]//h5") );
        assertEquals( secondFigCaptionH5.getText(), "name: user2" );
        thirdFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[3]//h5") );
        assertEquals( thirdFigCaptionH5.getText(), "" );

        WebElement thirdFigureImg = driver.findElement( By.xpath( "//div[@class='example']/div[3]/img") );
        action = new Actions(driver);
        action.moveToElement( thirdFigureImg ).perform();

        firstFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[1]//h5") );
        assertEquals( firstFigCaptionH5.getText(), "" );
        secondFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[2]//h5") );
        assertEquals( secondFigCaptionH5.getText(), "" );
        thirdFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[3]//h5") );
        assertEquals( thirdFigCaptionH5.getText(), "name: user3" );

    }    @Test
    public void hoverTest2() {
        //   Najedź myszką na pierwsze (z lewej) zdjęcie użytkownika
        WebElement firstFigureImg = driver.findElement(
                By.xpath( new Locator()
                        .directDescendant()
                            .withTag( "img")
                        .of().directDescendant()
                            .withTag( "div")
                            .first()
                        .of().anyDescendant()
                            .withTag("div")
                            .withClass( "example" )
                        .get()
                )
        );
        Actions action = new Actions(driver);
        action.moveToElement( firstFigureImg ).perform();

        //   Sprawdź, że po najechaniu myszką pod zdjęciem dostępny jest napis name: user1 oraz że, dla pozostałych dwóch kolejnych zdjęć podpis jest pusty
        WebElement firstFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[1]//h5") );
        assertEquals( firstFigCaptionH5.getText(), "name: user1" );
        WebElement secondFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[2]//h5") );
        assertEquals( secondFigCaptionH5.getText(), "" );
        WebElement thirdFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[3]//h5") );
        assertEquals( thirdFigCaptionH5.getText(), "" );

        //   Wykonaj analogicznie kroki 2 i 3 dla kolejnych zdjęć użytkownika
        WebElement secondFigureImg = driver.findElement( By.xpath( "//div[@class='example']/div[2]/img") );
        action = new Actions(driver);
        action.moveToElement( secondFigureImg ).perform();

        firstFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[1]//h5") );
        assertEquals( firstFigCaptionH5.getText(), "" );
        secondFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[2]//h5") );
        assertEquals( secondFigCaptionH5.getText(), "name: user2" );
        thirdFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[3]//h5") );
        assertEquals( thirdFigCaptionH5.getText(), "" );

        WebElement thirdFigureImg = driver.findElement( By.xpath( "//div[@class='example']/div[3]/img") );
        action = new Actions(driver);
        action.moveToElement( thirdFigureImg ).perform();

        firstFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[1]//h5") );
        assertEquals( firstFigCaptionH5.getText(), "" );
        secondFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[2]//h5") );
        assertEquals( secondFigCaptionH5.getText(), "" );
        thirdFigCaptionH5 = driver.findElement( By.xpath( "//div[@class='example']/div[3]//h5") );
        assertEquals( thirdFigCaptionH5.getText(), "name: user3" );

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}