package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BasePage {

    public WebDriver initializeDriver(String browser, String ENV) throws Exception {
        WebDriver driver;

        if (ENV.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else {
                throw new Exception("Browser not supported: " + browser);
            }
        } else if (ENV.equalsIgnoreCase("grid")) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } else {
                throw new Exception("Browser not supported: " + browser);
            }
        } else {
            throw new Exception("ENV not supported: " + ENV);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
