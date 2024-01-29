package pl.dev4lazy.locators;

/**
 * Notes:
 *      1. For lowest level element in path - start with any*() (anyDescendant(), anyA(), anyButton(), etc.) method
 *      2. For one element do not mix anyDescendant() with rest of any*() (anyA(), anyButton(), etc.) methods
 *         Examples:
 *         - correctly:
 *              .anyButton().withId( "butt")
 *         - incorrectly:
 *              .anyDescendant().anyButton().withId( "butt")
 *      3. For one element do not mix of() with .ofAnyDescendant()
 *         Examples:
 *         - correctly:
 *              of().anyButton().withId( "butt")
 *         - incorrectly:
 *              of().ofAnyDescendant().anyButton().withId( "butt")
 * Using:
 *         String locator = new Locator()
 *                  .anyA()
 *                      .withAttributeValueIncludingText( "href", "EST-2" )
 *                  .of().anyDiv()
 *                      .withId("Catalog")
 *                  .get()
 *         String locator = new Locator()
 *                 .anyDescendant()
 *                     .withTag( "a")
 *                     .withAttributeValueIncludingText( "href", "EST-2" )
 *                 .of().anyDescendant()
 *                     .withTag( "div")
 *                     .withId( "Catalog" )
 *                 .get();
 *
 */
public class Locator {

    /*
    todo !!! może zrezygnowac z of(), może wystarczy samo directDEscendant, albo anyDescendant()
    todo może jdnak zamiast lokatora zwracać String - body. Wtedy nie będzie potrzebne get()
    todo zrobic warstę wyżej np. Button.id( "Remove" )
     */
    private String body ="";
    private String segment = "";

    /* Selecting by a specific tag ------------------------------------------------*/
    /**
     * Uwaga: zwracają locatory dla potomka dowolnego poziomu
     * @return
     */


    public Locator anyA(){
        return anyDescendant().withTag( "a" );
    }

    public Locator anyButton(){
        return anyDescendant().withTag( "button" );
    }

    public Locator anyDiv(){
        return anyDescendant().withTag( "div" );
    }

    public Locator anyH4(){
        return anyDescendant().withTag( "h4" );
    }

    public Locator anyImg(){
        return anyDescendant().withTag( "img" );
    }

    public Locator anyInput(){
        return anyDescendant().withTag( "input" );
    }

    public Locator anyLi(){
        return anyDescendant().withTag( "li" );
    }

    public Locator anyUl(){
        return anyDescendant().withTag( "ui" );
    }


    /* Indicates the parent level path -------------------------------------------*/
    public Locator of() {
        body = segment+body;
        segment = "";
        return this;
    }

    /* Selecting root  ----------------------------------------------------------*/
    @Deprecated
    public Locator root() {
        segment = "/";
        return this;
    }

    public Locator ofRoot() {
        body = segment+body;
        segment = "/";
        return this;
    }
    /* Selecting by descendant kind ----------------------------------------------*/
    public Locator anyDescendant() {
        segment = segment+"//*";
        return this;
    }

    @Deprecated
    public Locator ofAnyDescendant() {
        body = segment+body;
        segment = segment+"//*";
        return this;
    }

    public Locator directDescendant() {
        segment = segment+"/*";
        return this;
    }

    @Deprecated
    public Locator ofDirectDescendant() {
        body = segment+body;
        segment = segment+"/*";
        return this;
    }

    /* Selecting by tag ----------------------------------------------------------*/
    public Locator withTag( String tagName ) {
        if ( getLastCharAsString(segment).equals("*") ) {
            segment = getTextWithoutLastChar( segment );
        }
        segment = segment+tagName;
        return this;
    }

    public String getLastCharAsString(String text ) {
        if (text.isEmpty()) {
            return "";
        } else {
            return String.valueOf(text.charAt(text.length() - 1));
        }
    }

    public String getTextWithoutLastChar( String text ) {
        return text.substring(0, text.length() - 1);
    }

    /* Selecting by attributes --------------------------------------------------*/
    public Locator withId( String idName ) {
        segment = withAttributeValue( "id", idName ).get();
        return this;
    }

    public Locator withClass( String className ) {
        segment = withAttributeValue( "class", className ).get();
        return this;
    }

    public Locator withName( String name ) {
        segment = withAttributeValue( "name", name ).get();
        return this;
    }

    public Locator withAttributeValue(String attributeName, String attributeValue ) {
        segment = segment+"[@"+attributeName+"='"+attributeValue+"']";
        return this;
    }

    public Locator withAttributeValueIncludingText(String attributeName, String attributeValue ) {
        segment = segment+"[contains(@"+attributeName+", '"+attributeValue+"')]";
        return this;
    }

    public Locator withAttribute(String attributeName ) {
        segment = segment+"[@"+attributeName+"]";
        return this;
    }

    public Locator withInnerText(String innerText ) {
        segment = segment+"[text()='"+innerText+"']";
        return this;
    }

    public Locator withInnerTextIncluding( String innerText ) {
        segment = segment+"[contains(text(),'"+innerText+"')]";
        return this;
    }

    /* Selecting order ------------------------------------------------------------*/
    public Locator first() {
        segment = nth(1 ).get();
        return this;
    }

    public Locator second() {
        segment = nth(2 ).get();
        return this;
    }

    public Locator third() {
        segment = nth(3 ).get();
        return this;
    }


    public Locator nth( int n ) {
        segment = segment+"["+n+"]";
        return this;
    }

    /* Creating a locator text ---------------------------------------------------*/
    public String get() {
        String locatorBody = segment+body;
        body = "";
        segment = "";
        return locatorBody;
    }

}
