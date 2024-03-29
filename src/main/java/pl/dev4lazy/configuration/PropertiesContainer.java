package pl.dev4lazy.configuration;

import java.util.Properties;
public class PropertiesContainer {
    //Statyczne pole do przechowywania properties
    private static Properties properties;
    //Konstruktor prywatny potrzebny do posiadania tylko jednej instancji klasy ConfigurationProperties
    //Wzorzec Singleton
    private PropertiesContainer() {
    }
    //Metoda służy do załadowania obiektu properties do statycznego obiektu typu Properties, dostępnego dla wszystkich
    // wątków
    public static void setProperties(Properties properties) {
        PropertiesContainer.properties = properties;
    }
    //Metoda zwraca nam wszystkie załadowane properties, jeśli nie są one null-em
    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Please set properties using setProperties() before calling getProperties()");
        }
        return properties;
    }
}