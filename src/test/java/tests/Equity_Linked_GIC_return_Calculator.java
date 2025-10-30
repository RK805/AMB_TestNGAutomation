package tests;

import RbcRoyalBank_Pages.RbcRoyal_Equity_linkedGICsPage;
import RbcRoyalBank_Pages.RbcRoyal_InvestmentCalculatorsAndToolsPage;
import RbcRoyalBank_Pages.RbcRoyal_RRSF_FutureValueCalculatorPage;
import RbcRoyalBank_Pages.RbcRoyal_investmentPage;
import Utility.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class Equity_Linked_GIC_return_Calculator extends BasePage {

    private static final Logger log = LogManager.getLogger(personalLoan.class);

    RbcRoyal_investmentPage rbcRoyalInvestmentPage ;
    RbcRoyal_RRSF_FutureValueCalculatorPage rbcRoyalRrsfFutureValueCalculatorPage;
    RbcRoyal_InvestmentCalculatorsAndToolsPage rbcRoyalInvestmentCalculatorsAndToolsPage;
    RbcRoyal_Equity_linkedGICsPage rbcRoyalEquityLinkedGICsPage;

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
    public void Equity_Linked_GIC_return()
    {
        rbcRoyalInvestmentPage = new RbcRoyal_investmentPage();
        rbcRoyalInvestmentCalculatorsAndToolsPage = new RbcRoyal_InvestmentCalculatorsAndToolsPage();
        rbcRoyalEquityLinkedGICsPage = new RbcRoyal_Equity_linkedGICsPage();

        rbcRoyalInvestmentPage.clickAllInvestmentToolsAndCalculators();
        rbcRoyalInvestmentCalculatorsAndToolsPage.clickEquityLinkedGICReturnCalculator();

        rbcRoyalEquityLinkedGICsPage.enterInitialInvestment("500000");
        rbcRoyalEquityLinkedGICsPage.enterGICDate();
        rbcRoyalEquityLinkedGICsPage.clickMarketSmartRedio();
        rbcRoyalEquityLinkedGICsPage.clickUSMarketSmartGICRedio();
        rbcRoyalEquityLinkedGICsPage.clickGICsTermYearsRedio();
        rbcRoyalEquityLinkedGICsPage.clickCalculateReturnValue ();
        rbcRoyalEquityLinkedGICsPage.getCurrentValueOfInvestment();
        rbcRoyalEquityLinkedGICsPage.getOriginalInvestment();
        rbcRoyalEquityLinkedGICsPage.getMinimumReturnValue();
        rbcRoyalEquityLinkedGICsPage.getMaximumReturnValue();
        rbcRoyalEquityLinkedGICsPage.getIBL();
        rbcRoyalEquityLinkedGICsPage.getCurrentIndexValue();
    }

    @AfterClass
    public void tearDown() {
        log.info("Tearing down test");
        quitDriver();
    }
}
