package RbcRoyalBank_Pages;

import Utility.BasePage;
import Utility.WebElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RbcRoyal_Equity_linkedGICsPage extends BasePage {
//    public RbcRoyal_Equity_linkedGICsPage(WebDriver driver) {
//        this.driver = driver;
//    }

    public static By log = By.xpath("//h2[@class='accordion-title active']");
    public static By initialInvestment = By.xpath("//div[@id='principal-container']//input[@id='principalamount']");
    public static By GICDate = By.xpath("//div[@id='date-container']//input[@class='date-picker-btn']");
    public static By yearselect = By.xpath("//div[@class='datepicker--cells datepicker--cells-years']//div");
    public static By monthselect = By.xpath("//div[@class='datepicker--cells datepicker--cells-months']//div");
    public static By dateselect = By.xpath("//div[@class='datepicker--cells datepicker--cells-days']//div");
    public static By MmarketSmartRedio = By.xpath("//label[contains(@data-dig-label,'MarketSmart GIC Guaranteed Minimum Return')]");
    public static By USMarketSmartGICRedio= By.xpath("//label[contains(@data-dig-label,'U.S. MarketSmart GIC')] ");
    public static By GICsTermYearsRedio = By.xpath("//label[contains(@data-dig-label,'GIC Return Calculator - Term - 5 years')]");
    public static By CalculateReturnValue = By.xpath("//button[text()='Calculate Return Value']");

    public static By CurrentValueOfInvestment = By.xpath("//p[text()='Current value of investment']/parent::div/p[@class='return-value']");
    public static By OriginalInvestment= By.xpath("//p[text()='Original investment']/parent::div/p[@class='principal-value']");
    public static By minimumReturnValue = By.xpath("//div[@class='grid-one-third type-guaranteed']//p[@class='min-return-value']");
    public static By maximumReturnValue = By.xpath("//div[@class='grid-one-third type-guaranteed']//p[@class='max-return-value']");
    public static By IBL = By.xpath("//div[@class='grid-one-third type-guaranteed']//p[@class='ibl-value']");
    public static By currentIndexValue = By.xpath("//div[@class='grid-one-third type-guaranteed']//p[@class='isl-value']");


    public void enterInitialInvestment(String investment) {
        WebElementUtility.implicitWait(driver, 5);
        WebElementUtility.scrollToElement(driver,log);
        WebElementUtility.mouseHoverAndClick(driver, initialInvestment);
        WebElementUtility.sendkeysToElement(driver, initialInvestment, investment);
    }

    public void enterGICDate() {
        WebElementUtility.implicitWait(driver, 5);
        WebElementUtility.clickElement(driver, GICDate);
        WebElementUtility.ListOfElement(driver,yearselect,"2025");
        WebElementUtility.ListOfElement(driver,monthselect,"Oct");
        WebElementUtility.ListOfElement(driver,dateselect,"14");
    }

    public void clickMarketSmartRedio() {
        WebElementUtility.implicitWait(driver, 5);
        WebElementUtility.selectOption(driver, MmarketSmartRedio);
    }

    public void clickUSMarketSmartGICRedio() {
        WebElementUtility.implicitWait(driver, 5);
        WebElementUtility.clickElement(driver, USMarketSmartGICRedio);
    }

    public void clickGICsTermYearsRedio() {
        WebElementUtility.implicitWait(driver, 5);
        WebElementUtility.scrollToElement(driver,USMarketSmartGICRedio);
        WebElementUtility.clickElement(driver, GICsTermYearsRedio);
    }

    public void clickCalculateReturnValue() {
        WebElementUtility.implicitWait(driver, 5);
        WebElementUtility.JSclickElement(driver, CalculateReturnValue);
    }

    public String getCurrentValueOfInvestment() {
        WebElementUtility.implicitWait(driver, 5);
        return WebElementUtility.getElementText(driver, CurrentValueOfInvestment);
    }

    public String getOriginalInvestment() {
        WebElementUtility.implicitWait(driver, 5);
        System.out.println(WebElementUtility.getElementText(driver, OriginalInvestment));
        return WebElementUtility.getElementText(driver, OriginalInvestment);
    }

    public String getMinimumReturnValue() {
        WebElementUtility.implicitWait(driver, 5);
        System.out.println(WebElementUtility.getElementText(driver, minimumReturnValue));
        return WebElementUtility.getElementText(driver, minimumReturnValue);
    }

    public String getMaximumReturnValue() {
        WebElementUtility.implicitWait(driver, 5);
        System.out.println(WebElementUtility.getElementText(driver, maximumReturnValue));
        return WebElementUtility.getElementText(driver, maximumReturnValue);
    }

    public String getIBL() {
        WebElementUtility.implicitWait(driver, 5);
        System.out.println(WebElementUtility.getElementText(driver, IBL));
        return WebElementUtility.getElementText(driver, IBL);
    }

    public String getCurrentIndexValue() {
        WebElementUtility.implicitWait(driver, 5);
        System.out.println(WebElementUtility.getElementText(driver, currentIndexValue));
        return WebElementUtility.getElementText(driver, currentIndexValue);
    }

}
