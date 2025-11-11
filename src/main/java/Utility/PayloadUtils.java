package Utility;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadUtils {

    public static String getPayload(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/" + fileName)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load payload: " + fileName, e);
        }
    }
}
