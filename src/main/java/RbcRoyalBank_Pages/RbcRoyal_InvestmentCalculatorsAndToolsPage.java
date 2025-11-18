package RbcRoyalBank_Pages;

import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RbcRoyal_InvestmentCalculatorsAndToolsPage  {

    private static final Logger log = LogManager.getLogger(RbcRoyal_InvestmentCalculatorsAndToolsPage.class);

    private WebDriver driver;

    public RbcRoyal_InvestmentCalculatorsAndToolsPage(WebDriver driver) {
        this.driver = driver;
    }

    public static By RRSPFutureValueCalculatorLink = By.xpath("//span[text()='RRSP Future Value Calculator']");
    public static By GICSelect = By.xpath("//span[text()='GIC Selector']");
    public static By EquityLinkedGICReturnCalculator = By.xpath("//span[text()='Equity-Linked GIC Return Calculator']");


    public void clickRRSPFutureValueCalculatorLink() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for Js click on the RRSP FutureValue");
        WebElementUtility.JSclickElement(driver, RRSPFutureValueCalculatorLink);
    }

    public void clickEquityLinkedGICReturnCalculator() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 20);
        log.info("Webdriver wait for scroll to the GICselect");
        WebElementUtility.scrollToElement(driver, GICSelect);
        log.info("Webdriver wait for moues And click on the EqGIC");
        WebElementUtility.mouseHoverAndClick(driver, EquityLinkedGICReturnCalculator);
    }
}
