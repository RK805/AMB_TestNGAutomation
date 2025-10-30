package tests;

import RbcRoyalBank_Pages.RbcRoyal_InvestmentCalculatorsAndToolsPage;
import RbcRoyalBank_Pages.RbcRoyal_RRSF_FutureValueCalculatorPage;
import RbcRoyalBank_Pages.RbcRoyal_investmentPage;

import Utility.BasePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class RRSF_FuturevalueCalculatoe extends BasePage {

    private static final Logger log = LogManager.getLogger(personalLoan.class);

    RbcRoyal_investmentPage rbcRoyalInvestmentPage ;
    RbcRoyal_RRSF_FutureValueCalculatorPage rbcRoyalRrsfFutureValueCalculatorPage;
    RbcRoyal_InvestmentCalculatorsAndToolsPage rbcRoyalInvestmentCalculatorsAndToolsPage;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        log.info("Starting test setup");
        initializeDriver(browser);
    }
    @Test
    public void testGoogle() {
        log.info("Opening loan website");
        driver.get("https://www.rbcroyalbank.com/investments/mutual-funds.html");
        String titel = driver.getTitle();
        // Add your assertions here
        log.info("Page title: " + getDriver().getTitle());
        Assert.assertEquals(titel,"Mutual Funds - RBC Royal Bank");
    }

    @Test(dependsOnMethods = {"testGoogle"})
    public void AllInvestmentToolsAndCalculators()
    {
        rbcRoyalInvestmentPage = new RbcRoyal_investmentPage();
        rbcRoyalRrsfFutureValueCalculatorPage = new RbcRoyal_RRSF_FutureValueCalculatorPage();
        rbcRoyalInvestmentCalculatorsAndToolsPage = new RbcRoyal_InvestmentCalculatorsAndToolsPage();

        try {
            rbcRoyalInvestmentPage.clickAllInvestmentToolsAndCalculators();
        }
        catch (AssertionError e) {
        log.error("Login test failed: " + e.getMessage(), e);
        throw e;
        }
    }
    @Test(dependsOnMethods = {"testGoogle","AllInvestmentToolsAndCalculators"})
    public void RRSPFutureValueCalculatorLink()
    {
        try {
            rbcRoyalInvestmentCalculatorsAndToolsPage.clickRRSPFutureValueCalculatorLink();
        }
        catch (AssertionError e) {
            log.error("Login test failed: " + e.getMessage(), e);
            throw e;
        }
    }

    @Test(dependsOnMethods = {"testGoogle","AllInvestmentToolsAndCalculators","RRSPFutureValueCalculatorLink"})
    public void fillingInvestment()
    {
        try {
            rbcRoyalRrsfFutureValueCalculatorPage.enterInvestmentValue("500000");
            rbcRoyalRrsfFutureValueCalculatorPage.enterRateOfReturn("10");
            rbcRoyalRrsfFutureValueCalculatorPage.enterNumberOfYears("5");
            rbcRoyalRrsfFutureValueCalculatorPage.clickCalculateButton();
            rbcRoyalRrsfFutureValueCalculatorPage.getValueOfInvestment();
            rbcRoyalRrsfFutureValueCalculatorPage.clickRecalculateButton();
        }
        catch (AssertionError e) {
            log.error("Login test failed: " + e.getMessage(), e);
            throw e;
        }

    }

    @AfterClass
    public void tearDown() {
        log.info("Tearing down test");
        quitDriver();
    }
}
