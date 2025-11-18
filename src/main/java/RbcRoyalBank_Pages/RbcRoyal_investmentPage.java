package RbcRoyalBank_Pages;


import Utility.BrowserUtility;
import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RbcRoyal_investmentPage  {

    private WebDriver driver;

    public RbcRoyal_investmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final Logger log = LogManager.getLogger(RbcRoyal_investmentPage.class);

    public static By  Investments = By.xpath("//a[text()='Investments' and @data-dig-action='Click Button']");
    public static By Investments_mutualFunds = By.xpath("//a[contains(@data-dig-label,'Investments - Mutual Funds')]");
    public static  By MutualFunds = By.xpath("//a[@data-dig-label='pbmenu - Investments - Mutual Funds']");
    public static  By InvestmentPerformanceSnapshot = By.xpath("//span[text()='Investment Performance Snapshot']");
    public static  By InvestmentPerformanceSnapshotText = By.xpath("//h1[text()='Investment Performance Snapshot']");
    public static  By placeHolder = By.xpath("//input[@placeholder='Select fund']");
    public static  By ListOfThePlaceHolder = By.xpath("//ul[@class='rbc-autocomplete-search-results']/li");
    public static  By SelectSeriesTextBox = By.xpath("//div[contains(@class,'rbc-dropdown')]/child::button[normalize-space()='Select series']");
    public static  By listOfTheSeriesTextBox = By.xpath("//ul[@role='listbox']/li[normalize-space()='A' or normalize-space()='O'or normalize-space()='D' or normalize-space()='F']");
    public static  By InitialInvestment = By.xpath("//input[@placeholder='Initial investment']");
    public static  By ContributionAmount = By.xpath("//input[@placeholder='Contribution amount']");
    public static  By FrequencyTextBox = By.xpath("//button[@aria-expanded='false' and @data-selected='BIWEEKLY' or data-selected='WEEKLY' or data-selected='MONTHLY'][1]");
    public static  By selectingWeeklyOption = By.xpath("//li[@aria-selected='true' and normalize-space()='Weekly']");
    public static  By AnnualIncrese = By.xpath("//span[text()='Annual increase ']/../following-sibling::rbc-dropdown//following::button[normalize-space()='Select'][1]");
    public static  By DONotApplyOption = By.xpath("//li[@aria-selected='true' and normalize-space()='Do not apply']");
    public static  By WithdrawalAmount = By.xpath("//label[normalize-space()='Withdrawal amount']/../following::input");
    public static  By ViewFundPerformanceButton = By.xpath("//slot[normalize-space()='View fund performance']/..");
    // Investment Performance Snapshot view
    public static By InitialInvestmentPrice = By.xpath("//p[normalize-space()='Initial investment']/following-sibling::div");
    public static By TotalDistributionsPrice = By.xpath("//p[normalize-space()='Total distributions']/following-sibling::div/div/h4");
    // scenario:2
    public static By allInvestmentToolsAndCalculatorsLink = By.xpath("//div//a[normalize-space()='All Investment Tools & Calculators']");
    public static By Loans = By.xpath("//a[text()='Loans' and @data-dig-action='Click Button']");
    public static By personalLoans = By.xpath("//a[contains(@data-dig-label,'Personal Loans')]");

    public void clickMutualFunds() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 10);
        log.info("Webdriver wait for the click on the Investments ");
        WebElementUtility.clickElement(driver,Investments);
        log.info("Webdriver wait for the investment visible");
        WebElementUtility.waitForElementVisible(driver, Investments, 10);
        log.info("Webdriver wait for the mouse over the Investment ");
        WebElementUtility.mouseHover(driver, Investments);
        log.info("Webdriver wait for the click on the Investment ");
        WebElementUtility.mouseHoverAndClick(driver, Investments_mutualFunds);
    }

    public void clickInvestmentPerformanceSnapshot() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 10);
        log.info("Webdriver wait for the InvestmentPerformanceSnapshot scroll to the element ");
        WebElementUtility.scrollToElement(driver, InvestmentPerformanceSnapshot);
        log.info("Webdriver wait for the InvestmentPerformanceSnapshot js click  ");
        WebElementUtility.JSclickElement(driver, InvestmentPerformanceSnapshot);
    }

    public void waitForInvestmentPerformanceSnapshotText() {
       // WebElementUtility.waitForElementVisible(driver, InvestmentPerformanceSnapshotText, 10);
        log.info("Webdriver wait for the switch to tab  ");
       BrowserUtility.switchToTabByIndex(driver, 1);
    }

    public void enterFundInPlaceHolder() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for the place holder click");
        WebElementUtility.clickElement(driver, placeHolder);
        log.info("Webdriver wait for the send the place holder ");
        WebElementUtility.sendkeysToElement(driver, placeHolder, "BlueBay $U.S. Global High Yield Bond Fund (Canada)");
        log.info("Webdriver wait for the list out the listOfThePlaceHolder ");
        WebElementUtility.ListOfElement(driver, ListOfThePlaceHolder, "BlueBay $U.S. Global High Yield Bond Fund (Canada)");
    }
    public  void clickSelectSeries()  {
        System.out.println("Clicking on Select Series");
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 5);
        log.info("Webdriver wait for click on  the select Series  ");
        WebElementUtility.JSclickElement(driver, SelectSeriesTextBox);
        log.info("Webdriver wait for list list Option the F ");
        WebElementUtility.ListOfElement(driver, listOfTheSeriesTextBox, "F");
    }

    public void  getListOfSeriesTextBoxOptions() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 10);

    }

    public void enterInitialInvestment(String investment) {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.clickElement(driver, InitialInvestment);
        log.info("Webdriver wait for enter the initialInvestment ");
        WebElementUtility.enterText(driver, InitialInvestment, investment);
    }

    public void enterContributionAmount(String contribution) {
        log.info("Webdriver wait for click on the Contribution Amount ");
        WebElementUtility.clickElement(driver, ContributionAmount);
        log.info("Webdriver wait for enter the contribution Amount ");
        WebElementUtility.enterText(driver, ContributionAmount, contribution);
    }

    public void clickFrequencyTextBox() {
        log.info("Webdriver wait for click on the FrequencyTestBox");
        WebElementUtility.clickElement(driver,FrequencyTextBox);
        log.info("Webdriver wait for JS click on the SelectingWeeklyOption");
        WebElementUtility.JSclickElement(driver, selectingWeeklyOption);
    }
    public void clickAnnualIncrease() {
        log.info("Webdriver wait for click on the AnnualIncrese");
        WebElementUtility.clickElement(driver, AnnualIncrese);
        log.info("Webdriver wait for JS click on the DONotApplyOption");
        WebElementUtility.JSclickElement(driver, DONotApplyOption);
    }
    public void enterWithdrawalAmount(String withdrawal) {
        log.info("Webdriver wait for click on the WithDrawalAmount");
        WebElementUtility.clickElement(driver, WithdrawalAmount);
        log.info("Webdriver wait for Enter the WithDrawalAmount ");
        WebElementUtility.enterText(driver, WithdrawalAmount, withdrawal);    }

    public void clickViewFundPerformanceButton() {
        log.info("Webdriver wait for JS click on the ViweFundPerformanceButton");
        WebElementUtility.JSclickElement(driver, ViewFundPerformanceButton);
    }

    public void checkInvestmentPerformanceSnapshotView() {
        log.info("Webdriver wait for getTest of the InititalInvestments");
        WebElementUtility.getElementText(driver, InitialInvestmentPrice);
        log.info("Webdriver wait for getText of the TotalDistribution");
        WebElementUtility.getElementText(driver, TotalDistributionsPrice);
        log.info("Webdriver wait for close the Browser");
        BrowserUtility.closeBrowser(driver);

    }

   public void clickAllInvestmentToolsAndCalculators() {
       log.info("Webdriver wait for the impliciwait");
       WebElementUtility.implicitWait(driver, 10);
       log.info("Webdriver wait for click on the Investment ");
        WebElementUtility.clickElement(driver,Investments);
       log.info("Webdriver wait for the impliciwait");
       WebElementUtility.implicitWait(driver, 10);
       log.info("Webdriver wait for Wait for the Investment");
       WebElementUtility.waitForElementVisible(driver, Investments, 10);
       log.info("Webdriver wait for mouse Hover the Investmnet ");
       WebElementUtility.mouseHover(driver, Investments);
       log.info("Webdriver wait for mouse hover and click on the AllInvestment ");
       WebElementUtility.mouseHoverAndClick(driver,allInvestmentToolsAndCalculatorsLink);
    }

    public void clickPersonalLoans() {
        log.info("Webdriver wait for the impliciwait");
        WebElementUtility.implicitWait(driver, 10);
        log.info("Webdriver wait for wait for the loans ");
        WebElementUtility.waitForElementVisible(driver, Loans, 10);
        log.info("Webdriver wait for mouseHover the Loans ");
        WebElementUtility.mouseHover(driver, Loans);
        log.info("Webdriver wait for JS click on the personal Loans  ");
        WebElementUtility.JSclickElement(driver, personalLoans);
    }

}

