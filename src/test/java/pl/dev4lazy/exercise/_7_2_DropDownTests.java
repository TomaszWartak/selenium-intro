package pl.dev4lazy.exercise;

/*
Zadanie 7.2:
Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
	1. Przejdź na stronę dropdown (https://theinternet.przyklady.javastart.pl/dropdown)
	2. Sprawdź, że po wejściu na stronę w kontrolce typu Dropdown jest wybrana opcja "Please select an option"
	3. Ustaw wartość na Option 1
	4. Sprawdź, że wybrana opcja to Option 1
	5. Ustaw wartość na Option 2
	6. Sprawdź, że wybrana opcja to Option 2
Inne wymagania:
	• Nazwa klasy testowej: DropDownTests
	• Nazwa metody testowej: dropDownTest

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class _7_2_DropDownTests {
    final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe";
    final String APP_URL = "https://theinternet.przyklady.javastart.pl/dropdown";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.navigate().to(APP_URL);
    }

    @Test
    public void dropDownTest() {
        WebElement webElement = driver.findElement( By.id( "dropdown" ) );
        Select dropdown = new Select( webElement );

        WebElement selectedOption = dropdown.getFirstSelectedOption();
        assertEquals( selectedOption.getText(), "Please select an option");

        dropdown.selectByValue("1");
        selectedOption = dropdown.getFirstSelectedOption();
        assertEquals( selectedOption.getText(), "Option 1");

        dropdown.selectByValue("2");
        selectedOption = dropdown.getFirstSelectedOption();
        assertEquals( selectedOption.getText(), "Option 2");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

