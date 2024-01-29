package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage {

    @FindBy( name = "username")
    private WebElement userNameInput;
    @FindBy( name = "password")
    private WebElement passwordInput;
    @FindBy( name = "signon")
    private WebElement signOnInput;
    @FindBy( xpath = "//ul[@class='messages']/li")
    private List<WebElement> messagesLi;

    public LoginPage() {
        PageFactory.initElements( DriverManager.getWebDriver(), this);
    }

    public void processLoginAndPassword(String login, String password) {
        typeInLoginInput( login );
        typeInPasswordInput( password );
        clickSignOnInput();
    }

    public void typeInLoginInput( String login ) {
        userNameInput.clear();
        userNameInput.sendKeys(login);
    }

    public void typeInPasswordInput( String password ) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignOnInput() {
        signOnInput.click();
    }

    public boolean isFailedMessageDisplayed(String failedMessage) {
        return !messagesLi.stream()
                .filter( li -> li.getText().equals( failedMessage ) )
                .map( li -> li.isDisplayed() )
                .collect(Collectors.toList())
                .isEmpty();
    }

}
