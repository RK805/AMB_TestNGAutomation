package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;
    protected static final Logger log = LogManager.getLogger(BasePage.class);

    public static void initializeDriver(String browser) {
        log.info("Initializing browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new org.openqa.selenium.chrome.ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
        } else {
            log.error("Unsupported browser: " + browser);
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        log.info(browser + " browser launched successfully.");
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Closing the browser");
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
