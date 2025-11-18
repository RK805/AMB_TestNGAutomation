package tests;

import RbcRoyalBank_Pages.RbcRoyal_investmentPage;
import RbcRoyalBank_Pages.RbcRoyal_personalLoansPage;
import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


public class Investment_Process_In_Mutual_Funds extends BaseTest {

    private static final Logger log = LogManager.getLogger(Investment_Process_In_Mutual_Funds.class);

    RbcRoyal_investmentPage rbcRoyalInvestmentPage ;
    RbcRoyal_personalLoansPage rbcRoyalPersonalLoansPage;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        log.info("Starting test setup");
//        initializeDriver(browser);
    }
    @Test
    public void testGoogle() {
        log.info("Opening loan website");
        try {
            driver.get("https://www.rbcroyalbank.com/investments/mutual-funds.html");
            String titel = driver.getTitle();
            log.info("Page title: " + getDriver().getTitle());
            Assert.assertEquals(titel, "Mutual Funds - RBC Royal Bank");
           }
        catch (AssertionError e) {
            log.error("Login test failed: " + e.getMessage(), e);
            throw e;
        }
    }

    @Test(dependsOnMethods = {"testGoogle"})
    public void mutualFundsInvestments()
    {
        rbcRoyalInvestmentPage = new RbcRoyal_investmentPage(driver);
        try {
            rbcRoyalInvestmentPage.clickMutualFunds();
        }
        catch (AssertionError e) {
            log.error("Login test failed: " + e.getMessage(), e);
            throw e;
       }
    }
    @Test(dependsOnMethods = {"testGoogle","mutualFundsInvestments"})
    public void InvestmentPerformanceSnapshot()
    {
        try {
            rbcRoyalInvestmentPage.clickInvestmentPerformanceSnapshot();
            rbcRoyalInvestmentPage.waitForInvestmentPerformanceSnapshotText();
        }
        catch (AssertionError e) {
        log.error("Login test failed: " + e.getMessage(), e);
        throw e;
    }
    }
    @Test(dependsOnMethods = {"testGoogle","mutualFundsInvestments","InvestmentPerformanceSnapshot"})
    public void InvestmentPerformanceSnapshotApplicationFill()
    {
        try {
            rbcRoyalInvestmentPage.enterFundInPlaceHolder();
            rbcRoyalInvestmentPage.clickSelectSeries();
            rbcRoyalInvestmentPage.getListOfSeriesTextBoxOptions();
            rbcRoyalInvestmentPage.enterInitialInvestment("500000");
            rbcRoyalInvestmentPage.enterContributionAmount("5000");
            rbcRoyalInvestmentPage.clickFrequencyTextBox();
            rbcRoyalInvestmentPage.clickAnnualIncrease();
            rbcRoyalInvestmentPage.enterWithdrawalAmount("1000");
            rbcRoyalInvestmentPage.clickViewFundPerformanceButton();
        }
        catch (AssertionError e) {
        log.error("Login test failed: " + e.getMessage(), e);
        throw e;
    }
    }
    @Test(dependsOnMethods = {"testGoogle","mutualFundsInvestments","InvestmentPerformanceSnapshot","InvestmentPerformanceSnapshotApplicationFill"})
    public void checkInvestmentPerformanceSnapshot()
    {
        try {
            rbcRoyalInvestmentPage.checkInvestmentPerformanceSnapshotView();
        }
        catch (AssertionError e) {
        log.error("Login test failed: " + e.getMessage(), e);
        throw e;
    }
    }

    @AfterClass
    public void tearDown() {
        log.info("Tearing down test");
       try {
//           quitDriver();
       }
        catch (AssertionError e) {
            log.error("Login test failed: " + e.getMessage(), e);
            throw e;
        }
    }
}
