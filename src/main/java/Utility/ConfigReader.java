package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // Default properties (testdata.properties)
    private static final Properties defaultProps = new Properties();

    static {
        loadDefaultProperties();
    }

    // Load default testdata.properties
    private static void loadDefaultProperties() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/configs/testdata.properties");
            defaultProps.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load testdata.properties: " + e.getMessage(), e);
        }
    }

    // Existing method for default properties
    public static String get(String key) {
        String value = defaultProps.getProperty(key);
        if (value == null) {
            throw new RuntimeException("❌ Property '" + key + "' not found in testdata.properties.");
        }
        return value;
    }

    // ✅ NEW: Load any properties file dynamically
    public static Properties load(String fileName) {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/configs/" + fileName);
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load " + fileName + ": " + e.getMessage(), e);
        }
        return props;
    }

    // ✅ NEW: Get a property from a specific file
    public static String get(String fileName, String key) {
        Properties props = load(fileName);
        String value = props.getProperty(key);
        if (value == null) {
            throw new RuntimeException("❌ Property '" + key + "' not found in " + fileName);
        }
        return value;
    }
}
