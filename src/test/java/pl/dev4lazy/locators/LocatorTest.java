package pl.dev4lazy.locators;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LocatorTest {

    Locator locator;

    @BeforeMethod
    public void before() {
        locator = new Locator();
    }

    @Test
    public void of() {
        assertEquals( locator.of().get(), ""  );
        assertEquals(
                locator.anyDescendant().withTag("img").of().root().withTag("input").get(),
                "/input//img"  );
        assertEquals(
                locator.directDescendant().withTag("img").of().root().withTag("input").get(),
                "/input/img"  );
        assertEquals(
                locator
                        .anyDescendant()
                            .withTag("img")
                            .withId( "obrazek")
                        .of().directDescendant()
                            .withTag("input")
                        .of().root()
                            .withTag("header")
                        .get(),
                "/header/input//img[@id='obrazek']"  );
    }

    @Test
    public void root() {
        assertEquals( locator.root().get(), "/"  );
    }

    @Test
    public void anyDescendant() {
        assertEquals( locator.anyDescendant().get(), "//*"  );
    }

    @Test
    public void directDescendant() {
        assertEquals( locator.directDescendant().get(), "/*"  );
    }

    @Test
    public void withTag() {
        assertEquals( locator.withTag( "input").get(), "input"  );
    }

    @Test
    public void getLastCharAsString__should_return_3__for_123() {
        String text = "123";
        assertEquals( locator.getLastCharAsString( text ), "3");
    }

    @Test
    public void getLastCharAsString__should_return_empty__for_empty() {
        String text = "";
        assertEquals( locator.getLastCharAsString( text ), "");
    }

    @Test
    public void havingId() {
        assertEquals( locator.withId("echo").get(), "[@id='echo']");
    }

    @Test
    public void withAttributeValue() {
        assertEquals( locator.withAttributeValue("name", "echo").get(), "[@name='echo']");
    }

    @Test
    public void withAttribute() {
        assertEquals( locator.withAttribute("name").get(), "[@name]");
    }

    @Test void withInnerTextEqualTo() {
        assertEquals( locator.withInnerText("xxx").get(), "[text()='xxx']");
    }


    @Test void withInnerTextIncluding() {
        assertEquals( locator.withInnerTextIncluding("xxx").get(), "[contains(text(),'xxx')]");
    }

    @Test
    public void get__should_give_proper_locator__for_root_input_with_id_equal_echo() {
        String locatorBody = locator
                .root()
                .withTag("input")
                .withId( "echo" )
                .get();
        assertEquals( locatorBody, "/input[@id='echo']");
    }

    @Test
    public void get__2should_give_proper_locator_with_children__for_root_input_with_name_equal_username() {
        String locator = new Locator()
                .anyDescendant()
                .withTag("input")
                .withAttributeValue( "name", "username" )
                .get();
        assertEquals( locator, "//input[@name='username']" );
    }

    @Test
    public void getNewSyntax__should_give_proper_locator_with_children__for_root_input_with_id_equal_echo() {
        String locatorBody = locator
                .root()
                .withTag("input")
                .withId( "echo" )
                .anyDescendant()
                .withTag( "img")
                .get();
        assertEquals( locatorBody, "/input[@id='echo']//img");
    }

    @Test
    public void get__2should_give_proper_locator_with_children__for_root_input_with_id_equal_echo() {
        String locator = new Locator()
                .anyDescendant()
                    .withTag( "img")
                .of().root()
                    .withTag("input")
                    .withId("echo")
                .get();
        assertEquals( locator, "/input[@id='echo']//img" );
    }

    /* "/input[@id='echo']//img"
       .anyDescendant().withTag( "img").of().root().withTag("input").havingId("echo")
       .anyDescendant()
            .withTag( "img")
       .of().root()
            .withTag("input")
            .havingId("echo")
     */

    /* "/input[@id='echo']//img"
       .anyDescendant( withTag( "img") ).of( root().withTag("input").havingId("echo") )
       .anyDescendant(
          withTag( "img") )
       .of(
          root()
         .withTag("input")
         .havingId("echo") )
     */
}