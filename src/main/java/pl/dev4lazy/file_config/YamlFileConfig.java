package pl.dev4lazy.file_config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlFileConfig implements FileConfig {
    private ObjectMapper objectMapper;

    public YamlFileConfig() {
        objectMapper = new ObjectMapper(new YAMLFactory());
    }

    @Override
    public void writeValue(String valueName, String value) {
        // TODO objectMapper.writeValue(new File(fileName), text);
    }

    @Override
    public String readValue(String valueName) {
        return null;
    }
}
