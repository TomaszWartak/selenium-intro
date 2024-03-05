package pl.dev4lazy.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.List;

//Klasa zaimplementowana zgodnie z instrukcją z http://joel-costigliola.github.io/assertj/assertj-assertions-generator.html
public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    //Instancja Logger - do logowania wiadomości
    private Logger logger = LogManager.getLogger( this.getClass() );

    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement){
        return new AssertWebElement(webElement);
    }
/*
    public static List<AssertWebElement> assertThat(List<WebElement> webElements) {
        return new List(AssertWebElement(webElements));
    }*/

    //Metoda do sprawdzania czy element jest wyświetlony
    public AssertWebElement isDisplayed(){
        logger.info("Checking if element is displayed");
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Element was not displayed!");
        }
        logger.info("WebElement was displayed!");
        return this;
    }

    //Metoda do sprawdzenia czy element posiada zadany tekst
    public AssertWebElement hasText(String expectedTextValue){
        logger.info("Checking if WebElement has text: " + expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedTextValue)){
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }

        logger.info("WebElement had expected text!");
        return this;
    }

}