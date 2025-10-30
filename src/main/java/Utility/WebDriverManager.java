package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager
{private static WebDriver driver;
    private static String browserType;

    private WebDriverManager() {}

    public static WebDriver getDriver(String browser) {
        if (driver == null || !browser.equalsIgnoreCase(browserType)) {
            browserType = browser;
            if (driver != null) {
                driver.quit();
            }
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }



    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            browserType = null;
        }
    }


}
