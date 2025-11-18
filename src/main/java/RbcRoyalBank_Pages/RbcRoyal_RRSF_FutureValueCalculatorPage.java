package RbcRoyalBank_Pages;


import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RbcRoyal_RRSF_FutureValueCalculatorPage  {

    private WebDriver driver;

    public RbcRoyal_RRSF_FutureValueCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final Logger log = LogManager.getLogger(RbcRoyal_RRSF_FutureValueCalculatorPage.class);

    public static By investmentValue = By.xpath("//div[contains(@style,'display')]/following::input[@id='current-value-input']");
    public static By rateOfReturn = By.xpath("//div[@id='average-tooltip']/following::input[@id='rate-of-return-input']");
    public static By numberOfyears = By.xpath("//div//input[@id='years-until-retirement']");
    public static By CalculateButton = By.xpath("//button[text()='Calculate']");
    public static By valueOfInvestmentPrices = By.xpath("//h2[@id='years-retirement-result']/following::p[@id='value-years-result']/span");
    public static By recalculateButton = By.xpath("//button[text()='Recalculate']");

    public void enterInvestmentValue(String value) {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for SendKey Investments ");
        WebElementUtility.sendkeysToElement(driver, investmentValue, value);
    }

    public void enterRateOfReturn(String rate) {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for click on the RateOfReturn");
        WebElementUtility.clickElement(driver, rateOfReturn);
        log.info("Webdriver wait for sendKey the rateOfReturn ");
        WebElementUtility.sendkeysToElement(driver, rateOfReturn, rate);
    }

    public void enterNumberOfYears(String years)  {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for scroll by the NumberOfYears ");
        WebElementUtility.scrollToElement(driver, numberOfyears);
        log.info("Webdriver wait for moues and click on the NumberOf Years ");
        WebElementUtility.mouseHoverAndClick(driver, numberOfyears);
        log.info("Webdriver wait for sendKey to the numberOf Years ");
        WebElementUtility.sendkeysToElement(driver, numberOfyears, years);
    }

    public void clickCalculateButton() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for Js click on  the calculate ");
        WebElementUtility.JSclickElement(driver, CalculateButton);
    }

    public String getValueOfInvestment() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for return the getElement Value of the Invesments ");
        return WebElementUtility.getElementText(driver,valueOfInvestmentPrices );
    }

    public void clickRecalculateButton() {
        log.info("Webdriver wait for recalculateButton");
        WebElementUtility.clickElement(driver, recalculateButton);
    }
}
