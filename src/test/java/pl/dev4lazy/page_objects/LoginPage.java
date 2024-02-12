package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.navigation.ApplicationURLs;
import pl.dev4lazy.waits.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends PageBase {

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
        pageUrl = ApplicationURLs.LOGIN_URL;
    }

    public void processLoginAndPassword(String login, String password) {
        typeInLoginInput( login );
        typeInPasswordInput( password );
        clickSignOnInput();
    }

    public void typeInLoginInput( String login ) {
        Waiter.untilElementIsVisible( userNameInput );
        userNameInput.clear();
        userNameInput.sendKeys(login);
        logger.info("typeInLoginInput");
    }

    public void typeInPasswordInput( String password ) {
        Waiter.untilElementIsVisible( passwordInput );
        passwordInput.clear();
        passwordInput.sendKeys(password);
        logger.info("typeInPasswordInput");
    }

    public void clickSignOnInput() {
        Waiter.untilElementIsClickable( signOnInput );
        signOnInput.click();
        logger.info("clickSignOnInput");
    }

    public boolean isFailedMessageDisplayed(String failedMessage) {
        Waiter.untilElementsAreVisible( messagesLi );
        logger.info("isFailedMessageDisplayed");
        String correctedFailedMessage = replaceDoubleSpacesForSingleSpace( failedMessage );
/*        List<String> messages = messagesLi.stream()
                .map( li -> li.getText() )
                .collect(Collectors.toList());
        String text = replaceDoubleSpacesForSingleSpace( messages.get(0) );*/
        return !messagesLi.stream()
                .filter( li -> replaceDoubleSpacesForSingleSpace( li.getText() ).equals( correctedFailedMessage ) )
                .map( li -> li.isDisplayed() )
                .collect( Collectors.toList() )
                .isEmpty();
    }

    private String replaceDoubleSpacesForSingleSpace( String text ) {
        return text.replaceAll("\\s+", " ");
    }
}
