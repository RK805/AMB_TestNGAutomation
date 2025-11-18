package tests;

import RbcRoyalBank_Pages.RbcRoyal_personalLoansPage;

import Utility.WebElementUtility;
import base.BaseTest;
import com.ambTestLab.adminDashBordPage;
import com.ambTestLab.adminEcommercePage;
import com.ambTestLab.loginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class AMB_UserLogin extends BaseTest {
    private static final Logger log = LogManager.getLogger(personalLoanTest.class);

    loginPage loginPage ;
    adminDashBordPage AdminDashBordPage;
    adminEcommercePage AdminEcommercePage ;
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
        driver.get("https://ambtestlab.netlify.app/");
        String titel = driver.getTitle();
        // Add your assertions here
//        log.info("Page title: " + getDriver().getTitle());
        Assert.assertEquals(titel,"AMB TestLab Mutual Funds");
    }

    @Test(dependsOnMethods = {"testGoogle"})
    public void loginAdmin() {
        loginPage = new loginPage(driver);
      try {
          log.info("click on the login button");
          loginPage.clickOnTheLoginButton();
      }
      catch (Exception e)
      {
          log.error("💣 Exception during booking creation: {}", e.getMessage(), e);
          Assert.fail("Test failed due to exception: " + e.getMessage());
      }
    }
    @Test(dependsOnMethods = {"testGoogle","loginAdmin"})
    public void enterTheAdminDetails(){
        loginPage = new loginPage(driver);
        try
        {
            log.info("enter the admin email ");
            loginPage.enterTheLoginDetails();
            WebElementUtility.shortWait(driver);
            String Admintitel = driver.getTitle();
            // Add your assertions here
//            log.info("Page title: " + getDriver().getTitle());
//            Assert.assertEquals(Admintitel,"Admin Panel - Mutual Funds");
        }
        catch (Exception e)
        {
            log.error("💣 Exception during booking creation: {}", e.getMessage(), e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"testGoogle","loginAdmin","enterTheAdminDetails"})
    public void checkingDashBord() {
        AdminDashBordPage = new adminDashBordPage(driver);
        try {
            log.info("🔍 Navigating to Dashboard tab...");

            // Step 1: Click on Dashboard tab
            AdminDashBordPage.clickOnTheBoardTab();
            WebElementUtility.shortWait(driver);

            // Step 2: Verify Dashboard Title
            AdminDashBordPage.checkingDashBoardTitle();

            log.info("✔ Dashboard tab opened and title verified successfully.");
            AdminDashBordPage.checkingTheViewSelectOption();
            log.info("✔ View Selector dropdown options selected successfully.");

        } catch (Exception e) {
            log.error("❌ Exception while checking dashboard: {}", e.getMessage(), e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        }
        @Test(dependsOnMethods = {"testGoogle","loginAdmin","enterTheAdminDetails","checkingDashBord"})
        public void checkingEcommerce() {
            AdminDashBordPage = new adminDashBordPage(driver);
            AdminEcommercePage = new adminEcommercePage(driver);
            try {
                log.info("🔹 Starting E-Commerce page checks...");

                log.info("📌 Checking Add Product details (Step 1)...");
                AdminEcommercePage.checkingTheEcommercePage();

                log.info("📌 Checking Add Product details (Step 2)...");
                AdminEcommercePage.checkingAddProductDetail();

                log.info("✔ Successfully checked Add Product details on E-Commerce page.");

            } catch (Exception e) {
                log.error("❌ Exception while checking dashboard: {}", e.getMessage(), e);
                Assert.fail("Test failed due to exception: " + e.getMessage());
            }
    }

    @AfterClass
    public void tearDown() {
        log.info("Tearing down test");
//        quitDriver();
    }
}
