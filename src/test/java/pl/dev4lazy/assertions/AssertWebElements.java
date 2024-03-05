package pl.dev4lazy.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

//Klasa zaimplementowana zgodnie z instrukcją z http://joel-costigliola.github.io/assertj/assertj-assertions-generator.html
public class AssertWebElements extends AbstractAssert<AssertWebElements, List<WebElement> > {

    //Instancja Logger - do logowania wiadomości
    private Logger logger = LogManager.getLogger( this.getClass() );

    public AssertWebElements( List<WebElement> webElements ) {
        super(webElements, AssertWebElements.class);
    }

    public static AssertWebElements assertThat( List<WebElement> webElements){
        return new AssertWebElements(webElements);
    }

    //Metoda do sprawdzania czy element jest wyświetlony
    public AssertWebElements areDisplayed(){
        logger.info("Checking if elements are displayed");
        isNotNull();

/* todo
        if(!actual.isDisplayed()){
            failWithMessage("Element was not displayed!");
        }
*/

        if ( !actual.stream().allMatch( webElement -> webElement.isDisplayed() ) ) {
           failWithMessage("Not all elements are displayed!");
        }
        logger.info("WebElements are displayed!");
        return this;
    }

    //Metoda do sprawdzenia czy element posiada zadany tekst
    public AssertWebElements haveText( String expectedTextValue ){
        logger.info("Checking if WebElement has text: " + expectedTextValue);
        isNotNull();

/*  todo      String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedTextValue)){
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }*/

        if ( actual.stream()
                .filter( webElement -> replaceDoubleSpacesForSingleSpace( webElement.getText() ).equals( expectedTextValue ) )
                .collect( Collectors.toList() )
                .isEmpty() ) {
            failWithMessage("Elements have no text:  <%s>!", expectedTextValue);
        }

        logger.info("WebElement had expected text!");
        return this;
    }

    private String replaceDoubleSpacesForSingleSpace( String text ) {
        return text.replaceAll("\\s+", " ");
    }

}