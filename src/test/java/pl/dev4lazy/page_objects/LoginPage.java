package pl.dev4lazy.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.dev4lazy.driver_manager.DriverManager;
import pl.dev4lazy.navigation.ApplicationURLs;
import pl.dev4lazy.waits.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends BasePage {

    @FindBy( name = "username")
    private WebElement userNameInput;
    @FindBy( name = "password")
    private WebElement passwordInput;
    @FindBy( name = "signon")
    private WebElement signOnInput;
    @FindBy( xpath = "//ul[@class='messages']/li")
    private List<WebElement> messagesLi;

    public LoginPage() {
        super();
        pageUrl = ApplicationURLs.LOGIN_URL;
    }

    public void processLoginAndPassword(String login, String password) {
        typeInLoginInput( login );
        typeInPasswordInput( password );
        clickSignOnInput();
    }

    public void typeInLoginInput( String login ) {
        logger.info( System.lineSeparator()+"typeInLoginInput");
        Waiter.untilElementIsVisible( userNameInput );
        userNameInput.clear();
        userNameInput.sendKeys(login);
    }

    public void typeInPasswordInput( String password ) {
        logger.info( System.lineSeparator()+"typeInPasswordInput");
        Waiter.untilElementIsVisible( passwordInput );
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignOnInput() {
        logger.info( System.lineSeparator()+"clickSignOnInput");
        Waiter.untilElementIsClickable( signOnInput );
        signOnInput.click();
    }

    public boolean isFailedMessageDisplayed(String failedMessage) {
        logger.info( System.lineSeparator()+"isFailedMessageDisplayed: "+failedMessage );
        Waiter.untilElementsAreVisible( messagesLi );
        String correctedFailedMessage = replaceDoubleSpacesForSingleSpace( failedMessage );
        return !messagesLi.stream()
                .filter( li -> replaceDoubleSpacesForSingleSpace( li.getText() ).equals( correctedFailedMessage ) )
                .map( li -> li.isDisplayed() )
                .collect( Collectors.toList() )
                .isEmpty();
    }

    private String replaceDoubleSpacesForSingleSpace( String text ) {
        return text.replaceAll("\\s+", " ");
    }

/* todo (uzycie własnych asercji z logowaniem) na razie zostaje, ale do usunięcia
    public void assertThatWarningIsDisplayed(String failedMessage) {
        logger.info( System.lineSeparator()+"assertThatWarningIsDisplayed: "+failedMessage );
        Waiter.untilElementsAreVisible( messagesLi );
        AssertWebElements.assertThat( messagesLi ).areDisplayed().haveText( failedMessage );
    }*/

}
