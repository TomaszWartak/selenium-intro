package pl.dev4lazy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
