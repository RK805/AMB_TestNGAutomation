package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Get WebDriver instance (thread-safe)
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Initialize WebDriver
    public static void initDriver(String browser, String env, String gridUrl) {
        WebDriver webDriver;

        switch (env.toLowerCase()) {
            case "local":
                webDriver = initLocalDriver(browser);
                break;

            case "grid":
                webDriver = initGridDriver(browser, gridUrl);
                break;

            default:
                throw new RuntimeException("Environment not supported: " + env);
        }

        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    private static WebDriver initLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(new ChromeOptions());
            case "firefox":
                return new FirefoxDriver(new FirefoxOptions());
            default:
                throw new RuntimeException("Local browser not supported: " + browser);
        }
    }

    private static WebDriver initGridDriver(String browser, String gridUrl) {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    return new RemoteWebDriver(new URL(gridUrl), new ChromeOptions());
                case "firefox":
                    return new RemoteWebDriver(new URL(gridUrl), new FirefoxOptions());
                default:
                    throw new RuntimeException("Grid browser not supported: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
        }
    }

    // Quit WebDriver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
