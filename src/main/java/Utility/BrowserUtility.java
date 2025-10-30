package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtility extends BasePage {

//    public BrowserUtility(WebDriver driver) {
//        super(driver);
//    }

    // Selenium Browser Initialization
    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }
    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
    public static void QuitBrowser(WebDriver driver) {
        driver.quit();
    }
    public static void closeBrowser(WebDriver driver) {
        driver.close();
    }

    // Selenium Browser Commands
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }
    public static void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }
    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    // Selenium Frames Commands
    public static void switchToFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }
    public static void switchToFrameByNameOrId(WebDriver driver, String nameOrId) {

        driver.switchTo().frame(nameOrId);
    }
    public static void switchToFrameByElement(WebDriver driver, By locator) {

        driver.switchTo().frame(driver.findElement(locator));
    }
    public static void switchToDefaultContent(WebDriver driver) {

        driver.switchTo().defaultContent();
    }
    // tabs
    public static void switchToTabByIndex(WebDriver driver, int tabIndex) {

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    public static void closeExtraTabs(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.close(); // close the ad or extra tab
            }
        }

        driver.switchTo().window(mainWindow); // go back to main window
    }

    /**
     * This method tries to close or cancel ads/popups if they appear.
     * It’s safe to call even if no ad is present — it won’t throw exceptions.
     */
    public static void closeAdsIfPresent(WebDriver driver) {
        try {
            // Example 1: Close button for a popup ad
            By closeButton = By.cssSelector(".ad-close, .popup-close, .close-btn");
            if (driver.findElements(closeButton).size() > 0) {
                WebElement close = driver.findElement(closeButton);
                if (close.isDisplayed()) {
                    close.click();
                    System.out.println("Ad closed successfully.");
                }
            }

            // Example 2: Handle iframe-based ad
            if (driver.findElements(By.tagName("iframe")).size() > 0) {
                for (WebElement frame : driver.findElements(By.tagName("iframe"))) {
                    driver.switchTo().frame(frame);
                    if (driver.findElements(closeButton).size() > 0) {
                        driver.findElement(closeButton).click();
                        System.out.println("Ad closed inside iframe.");
                    }
                    driver.switchTo().defaultContent();
                }
            }

        } catch (Exception e) {
            System.out.println("No ads found or could not close ad: " + e.getMessage());
        }
    }

    // Selenium Windows Commands
    public static String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }
    public static Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }
    public static void switchToWindow(WebDriver driver, String handle) {
        driver.switchTo().window(handle);
    }



}
