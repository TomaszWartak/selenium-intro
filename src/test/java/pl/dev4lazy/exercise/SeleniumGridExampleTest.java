package pl.dev4lazy.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import static org.testng.Assert.assertTrue;
public class SeleniumGridExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        ChromeOptions capability = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:8089"), capability);
    }

    @Test
    public void searchInDuckDuckGoTest() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.name("q")).sendKeys("JavaStart");
        driver.findElement(By.name("q")).submit();
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
