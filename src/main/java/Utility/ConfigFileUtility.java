package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileUtility {
    public static Properties readPropertiesFile(String filePath) throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        }
        return props;
    }

    public static void writePropertiesFile(String filePath, Properties props) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            props.store(fos, null);
        }
    }


}
