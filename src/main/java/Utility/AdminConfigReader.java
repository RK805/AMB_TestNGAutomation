package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AdminConfigReader {
    private static Properties properties;

    public static void loadAdminConfig() {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/configs/Admin.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadAdminConfig();
        }
        return properties.getProperty(key);
    }
}