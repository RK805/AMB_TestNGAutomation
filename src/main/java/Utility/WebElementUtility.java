package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebElementUtility{



//    WebDriverManager m= new WebDriverManager(driver);
//    // Selenium Web Elements Commands
    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
    public static List<WebElement> findElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }
    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;   // Element not found → return false
        }
    }
    public static String  getTextPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
    public static boolean isElementEnabled(WebDriver driver, By locator) {
        return driver.findElement(locator).isEnabled();
    }
    public static boolean isElementSelected(WebDriver driver, By locator) {
        return driver.findElement(locator).isSelected();
    }
    public static void clickElement(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
    public static String getElementText(WebDriver driver, By locator) {
        return driver.findElement(locator).getText();
    }
    public static void getElementTEXT(WebDriver driver, By locator) {
         driver.findElement(locator).getText();
    }
    public static void clearElement(WebDriver driver, By locator) {
        driver.findElement(locator).clear();
    }
    public static void sendkeysToElement(WebDriver driver, By locator, String keys) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(keys);
    }
    public static void JSclickElement(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    // Selenium Text Box Commands
    public static void enterText(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    public static String getTextBoxValue(WebDriver driver, By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    // Selenium Dropdown Box
    public static void selectDropdownByVisibleText(WebDriver driver, By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }
    public static void selectDropdownByValue(WebDriver driver, By locator, String value) {
        new Select(driver.findElement(locator)).selectByValue(value);
    }
    public static void selectDropdownByIndex(WebDriver driver, By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);
    }

    // Selenium Button Commands
    public static void clickButton(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    // Selenium Radio Button
    public static void selectRadioButton(WebDriver driver, By locator) {
        WebElement radio = driver.findElement(locator);
        if (!radio.isSelected()) {
            radio.click();
        }
    }

    // Selenium Check Box Commands
    public static void checkCheckbox(WebDriver driver, By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    public static void uncheckCheckbox(WebDriver driver, By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Selenium Actions Commands
    public static void mousemoveToElement(WebDriver driver,WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
    public static void mouseHover(WebDriver driver, By locator) {
        new Actions(driver).moveToElement(driver.findElement(locator)).build().perform();
    }
    public static void mouseHoverAndClick(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).click().build().perform();
    }
    public static void doubleClick(WebDriver driver, By locator) {
        new Actions(driver).doubleClick(driver.findElement(locator)).perform();
    }
    public static void rightClick(WebDriver driver, By locator) {
        new Actions(driver).contextClick(driver.findElement(locator)).perform();
    }
    public static void dragAndDrop(WebDriver driver, By source, By target) {
        new Actions(driver).dragAndDrop(driver.findElement(source), driver.findElement(target)).perform();
    }

    // Selenium Synchronization Commands
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForPageLoad(WebDriver driver, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }
    public static void  implicitWait(WebDriver driver, int timeoutSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutSeconds));
    }

    public static void shortWait(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
    }

    // srolling options
    public static void  scrollingToElementofAPage(WebDriver driver,By locator) {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", locator);
    }
    public static void scrollToElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            System.out.println("Driver does not support JavascriptExecutor. Cannot scroll to element.");
        }
    }
// list of elements
    public static void ListOfElement(WebDriver driver, By locator,String text) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            if (element.getText().trim().equals(text)) {
//                System.out.println("Element found: " + element.getText());
                element.click();
                break;
            }
        }
    }
    public static void selectOption(WebDriver driver, By locator)
    {
        WebElement radioButton = driver.findElement(locator);
        boolean isSelected = radioButton.isSelected();

        // Print the result
        if (isSelected) {
            System.out.println("The radio button is selected.");
        } else {
            radioButton.click();
            System.out.println("The radio button is NOT selected.");
        }
    }

    // ---------------- existing methods kept as-is above this region ----------------
    // (omit here for brevity) ...
    // ---------------------------------------------------------------------------------

    /**
     * Blink a WebElement (by toggling border) — once.
     * Use when you already have a WebElement reference.
     */
    public static void blinkElement(WebDriver driver, WebElement element) {
        if (driver == null || element == null) return;

        if (!(driver instanceof JavascriptExecutor)) {
            // If driver doesn't support JS execution, do nothing
            return;
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Add red border
            js.executeScript("arguments[0].style.border='3px solid red'", element);
            Thread.sleep(100);  // short pause
            // Remove border
            js.executeScript("arguments[0].style.border=''", element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupted status
        } catch (Exception e) {
            System.out.println("blinkElement error: " + e.getMessage());
        }
    }


    /**
     * Blink using a By locator (finds element first).
     */
    public static void blinkElement(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            blinkElement(driver, element);
        } catch (Exception e) {
            System.out.println("blinkElement(By) error: " + e.getMessage());
        }
    }


    /**
     * Scroll to, blink, hover (move mouse), but do not click.
     */
    public static void hoverWithBlink(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            // scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            // blink
            blinkElement(driver, element);
            // hover
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("hoverWithBlink error: " + e.getMessage());
        }
    }


}
