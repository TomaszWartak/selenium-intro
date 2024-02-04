package pl.dev4lazy.file_config;

public interface FileConfig {

    void writeValue( String valueName, String value );

    String readValue( String valueName );

}
