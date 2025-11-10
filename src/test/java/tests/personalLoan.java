package tests;

import RbcRoyalBank_Pages.RbcRoyal_investmentPage;
import RbcRoyalBank_Pages.RbcRoyal_personalLoansPage;
import Utility.BasePage;
import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


public class personalLoan extends BasePage  {

    private static final Logger log = LogManager.getLogger(personalLoan.class);

    RbcRoyal_investmentPage rbcRoyalInvestmentPage ;
    RbcRoyal_personalLoansPage rbcRoyalPersonalLoansPage;

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
    public void personalLoanApply() {
        rbcRoyalInvestmentPage = new RbcRoyal_investmentPage();
        rbcRoyalPersonalLoansPage = new RbcRoyal_personalLoansPage();

        log.info("Starting performance timing for personal loan process...");

        // Start timer
        long startTime = System.currentTimeMillis();

        try {
            rbcRoyalInvestmentPage.clickPersonalLoans();
            rbcRoyalPersonalLoansPage.clickBorrowingReasonDropdown();
            rbcRoyalPersonalLoansPage.selectBorrowingReason("Major Purchase");
            rbcRoyalPersonalLoansPage.enterLoanAmount("10000");
            rbcRoyalPersonalLoansPage.clickGetResultsButton();
            rbcRoyalPersonalLoansPage.enterInterestRate("10");
            rbcRoyalPersonalLoansPage.clickLoanButton();
            rbcRoyalPersonalLoansPage.selectRepaymentPeriod();
            rbcRoyalPersonalLoansPage.selectRepaymentPeriodOption("5 years");
            rbcRoyalPersonalLoansPage.selectMonthlyPayment("Semi-monthly");
            rbcRoyalPersonalLoansPage.clickGetRelust();
            WebElementUtility.waitForPageLoad(driver, 10);
            String amount = rbcRoyalPersonalLoansPage.getResultAmount();
            System.out.println("The return amount of the personal loan: " + amount);

        } catch (AssertionError e) {
            log.error("Loan test failed: " + e.getMessage(), e);
            throw e;
        }

        // Stop timer
        long endTime = System.currentTimeMillis();

        // Calculate and log duration
        long totalTime = endTime - startTime;
        log.info("Total time taken for one user to complete the loan process: " + totalTime + " ms");

        // Optional: You can fail the test if it exceeds a threshold (e.g., 10 seconds)
        Assert.assertTrue(totalTime < 100000, "Performance issue: process took too long (" + totalTime + " ms)");
    }


    @AfterClass
    public void tearDown() {
        log.info("Tearing down test");
        quitDriver();
    }
}
