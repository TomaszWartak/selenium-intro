package pl.dev4lazy.locators;

public class Locator {

    /*
    todo !!! może zrezygnowac z of(), może wystarczy samo directDEscendant, albo anyDescendant()
    todo może jdnak zamiast lokatora zwracać String - body. Wtedy nie będzie potrzebne get()
    todo zrobic warstę wyżej np. Button.id( "Remove" )
     */
    private String body ="";
    private String segment = "";

    public Locator of() {
        body = segment+body;
        segment = "";
        return this;
    }

    public Locator root() {
        segment = "/";
        return this;
    }

    public Locator anyDescendant() {
        segment = segment+"//*";
        return this;
    }

    public Locator directDescendant() {
        segment = segment+"/*";
        return this;
    }

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

    public Locator withAttribute(String attributeName ) {
        segment = segment+"[@"+attributeName+"]";
        return this;
    }

    public Locator withInnerTextEqualTo( String innerText ) {
        segment = segment+"[text()='"+innerText+"']";
        return this;
    }

    public Locator withInnerTextIncluding( String innerText ) {
        segment = segment+"[contains(text(),'"+innerText+"')]";
        return this;
    }

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

    public String get() {
        String locatorBody = segment+body;
        body = "";
        segment = "";
        return locatorBody;
    }

}
