package com.ambTestLab;
import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminDashBordPage  {
    private WebDriver driver;

    // Constructor receives driver from test
    public adminDashBordPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(adminDashBordPage.class);


    public static By dashboardTab = By.xpath("//div[@id='sidebar']//a[@data-page='dashboard']");
    public static By dashboardOverviewTitle = By.xpath("//h2[text()='Dashboard Overview']");
    public static By viewSelectorDropDown  = By.xpath("//div[@class='container-fluid']//select[@id='viewSelector']");
    public static By selectViewMutualFundsOption = By.xpath("//div[@class='container-fluid']//select[@id='viewSelector']//option[text()='Mutual Funds']");
    public static By selectViewE_CommerceOption = By.xpath("//div[@class='container-fluid']//select[@id='viewSelector']//option[text()='E-Commerce']");
    public static By selectViewSoftwareTestingOption = By.xpath("//div[@class='container-fluid']//select[@id='viewSelector']//option[text()='Software Testing']");
    public static By MarketSnapshotTitle = By.xpath("//div[@class='card market-card']//h5[normalize-space(.)='Market Snapshot']");
    public static By adminUser = By.xpath("//div[@class='container-fluid']//span[text()='Admin ']");
    public static By registeredInvestors = By.xpath("//p[text()='Registered Investors']//parent::div//h3[@id='registeredInvestors']");
    public static By activeSipPlans = By.xpath("//p[text()='Active SIP Plans']//parent::div//h3[@id='activeSipPlans']");
    public static By managedFunds = By.xpath("//p[text()='Managed Mutual Funds']//parent::div//h3[@id='managedFunds']");
    public static By orderVolume = By.xpath("//p[text()='Total Order Value']//parent::div//h3[@id='orderVolume']");
    public static By indexNameList = By.xpath("//div[@class='card market-card']//table//th[@scope='row']");
    public static By sensexChart = By.xpath("//rec[@id='sensexChart']//*[name()='circle']");
    public static By niftyChart = By.xpath("//rec[@id='niftyChart']//*[name()='circle']");
    public static By loginButton = By.xpath("//div[@id='sidebar']//a[@id='logoutBtn']");

    /**
     * Clicks on the Dashboard tab and logs each step.
     */
    public void clickOnTheBoardTab() {
        try {
            log.info("🟢 Waiting for the Dashboard tab to be visible...");
            WebElementUtility.implicitWait(driver, 5);

            log.info("🔹 Hovering on the Dashboard tab...");
            WebElementUtility.hoverWithBlink(driver, dashboardTab);

            log.info("🔹 Clicking on the Dashboard tab...");
            WebElementUtility.clickElement(driver, dashboardTab);

            log.info("✅ Dashboard tab clicked successfully.");
        } catch (Exception e) {
            log.error("❌ Failed to click on the Dashboard tab: {}", e.getMessage(), e);
            throw e; // or Assert.fail() if used in TestNG test
        }
    }

    /**
     * Checks the Dashboard Overview title by hovering and logs each step.
     */
    public void checkingDashBoardTitle() {
        try {
            log.info("🟢 Hovering over the Dashboard Overview title...");
            WebElementUtility.hoverWithBlink(driver, dashboardOverviewTitle);

            log.info("✅ Dashboard Overview title is displayed successfully.");
        } catch (Exception e) {
            log.error("❌ Failed to verify Dashboard Overview title: {}", e.getMessage(), e);
            throw e; // or Assert.fail() if used in TestNG test
        }
    }

    public void checkingTheViewSelectOption() {
        try {
            log.info("🔽 Opening the View Selector dropdown...");
            WebElementUtility.hoverWithBlink(driver, viewSelectorDropDown);
            WebElementUtility.clickElement(driver, viewSelectorDropDown);

//            log.info("📌 Selecting the 'Mutual Funds' option...");
//            WebElementUtility.mouseHoverAndClick(driver, selectViewMutualFundsOption);

//            log.info("🔽 Opening the View Selector dropdown again...");
//            WebElementUtility.clickElement(driver, viewSelectorDropDown);

            log.info("🛒 Selecting the 'E-Commerce' option...");
            WebElementUtility.clickElement(driver, selectViewE_CommerceOption);
            WebElementUtility.clickElement(driver, viewSelectorDropDown);

            log.info("✔ View selection process completed successfully.");

        } catch (Exception e) {
            log.error("❌ Error while selecting view options: {}", e.getMessage(), e);
            throw e; // or Assert.fail() if calling from TestNG test
        }
    }




}
