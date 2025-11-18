package RbcRoyalBank_Pages;

import Utility.WebElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RbcRoyal_DashBordPage  {

    private WebDriver driver;

    // Constructor receives driver from test
    public RbcRoyal_DashBordPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final String HOME_PAGE_URL = "https://www.rbcroyalbank.com/";

    public static   By Investments=By.xpath("//a[text()='Investments' and @data-dig-action='Click Button']");
    public static By Investments_mutualFunds=By.xpath("//a[contains(@data-dig-label,'Investments - Mutual Funds')]");
    public static  By Investments_AllInvestmentTools=By.xpath("//a[contains(@data-dig-label,'Investments - All Investment Tools & calculators')]");
    public static By allCalculate=By.xpath("//a[normalize-space()='All Investment Tools & Calculators']");
    public static By Loans = By.xpath("//a[text()='Loans' and @data-dig-action='Click Button']");
    public static By personalLoans = By.xpath("//a[contains(@data-dig-label,'Personal Loans')]");  //Personal Loans


    public void navigateTOHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void clickPersonalLoans() {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.waitForElementVisible(driver, Investments, 10);
        WebElementUtility.mouseHover(driver, Loans);
        WebElementUtility.JSclickElement(driver, personalLoans);
    }


}
