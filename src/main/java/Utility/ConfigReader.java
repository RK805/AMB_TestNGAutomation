package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/configs/testdata.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load config.properties file: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            throw new RuntimeException("❌ Property '" + key + "' not found in config.properties file.");
        }
        return value;
    }
}
