package pl.dev4lazy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/*
Zadanie 7.3:
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
	1. Przejdź na stronę upload (https://theinternet.przyklady.javastart.pl/upload)
	2. Wybierz plik z nazwą testfile.txt*
	3. Załaduj plik, klikając w przycisk Upload
	4. Sprawdź, że po załadowaniu pliku jego nazwa dostępna jest na stronie
* - Przed przystąpieniem do pracy utwórz w dowolnym miejscu na dysku plik testfile.txt z dowolną treścią.
Inne wymagania:
	• Nazwa klasy testowej: FileUploadTests
	• Nazwa metody testowej: fileUploadTest
 */
public class _7_3_FileUploadTests {
    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/upload";
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH );
        driver = new ChromeDriver();
        driver.navigate().to( APP_URL );
    }
    @Test
    public void fileUploadTest() {
        WebElement fileUploadButton = driver.findElement( By.id( "file-upload"));
        fileUploadButton.sendKeys( "C:\\Users\\PC\\Downloads\\testfile.txt");

        WebElement fileSubmitButton = driver.findElement( By.id( "file-submit"));
        fileSubmitButton.click();

        WebElement uploadedFilesDiv = driver.findElement( By.id( "uploaded-files"));
        assertEquals( "testfile.txt", uploadedFilesDiv.getText() );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
