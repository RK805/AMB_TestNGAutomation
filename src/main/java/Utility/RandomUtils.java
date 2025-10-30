package Utility;

import java.util.Random;
import java.util.UUID;

public class RandomUtils {

    private static final Random random = new Random();

    // ✅ Generate random 6-digit number
    public static int getRandom6DigitNumber() {
        return 100000 + random.nextInt(900000000);
    }

    // ✅ Generate random number within a range
    public static int getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // ✅ Generate random string (letters only)
    public static String getRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    // ✅ Generate random email
    public static String getRandomEmail() {
        return "navi" + getRandom6DigitNumber() + "@testmail.com";
    }

    // ✅ Generate random UUID (universally unique identifier)
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}