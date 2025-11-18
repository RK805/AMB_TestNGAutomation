package base;

import Utility.ConfigReader;
import Utility.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected static final Logger log = LogManager.getLogger(BaseTest.class);

    @Parameters({"browser", "env"})
    @BeforeClass(alwaysRun = true)
    public void setup(@Optional("chrome") String browser,
                      @Optional("local") String envParam) throws Exception {

        // Pick environment: System property (-DENV=...) > TestNG XML parameter > default "local"
        String env = System.getProperty("ENV");
        if (env == null || env.isEmpty()) {
            env = (envParam == null || envParam.isEmpty()) ? "local" : envParam;
        }

        browser = (browser == null || browser.isEmpty()) ? "chrome" : browser;

        log.info("Initializing WebDriver for env: " + env + ", browser: " + browser);

        // For grid, read URL from properties file
        String gridUrl = null;
        if (env.equalsIgnoreCase("grid")) {
            Properties gridProps = ConfigReader.load("grid.properties");
            gridUrl = gridProps.getProperty("AMB_GRID_URL");
        }

        DriverFactory.initDriver(browser, env, gridUrl);
        driver = DriverFactory.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        log.info("Closing browser...");
        DriverFactory.quitDriver();
    }

    // Getter for driver
    public WebDriver getDriver() {
        return driver;
    }
}
