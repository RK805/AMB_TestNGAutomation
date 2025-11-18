package com.ambTestLab;

import RbcRoyalBank_Pages.AccountCreated_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class adminPurchasesPage {

    private WebDriver driver;

    public adminPurchasesPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(adminPurchasesPage.class);

    // Page Elements
    public static By title = By.xpath("//div[@id='purchases-page']//following::h2[text()='Customer Purchases']");
    public static By searchInput = By.xpath("//input[@id='purchaseSearchInput']");
    public static By totalOrders = By.xpath("//p[text()='Total Orders']//parent::div//h3[@id='purchasesSummaryOrders']");
    public static By grossVolume = By.xpath("//p[text()='Gross Volume']//parent::div//h3[@id='purchasesSummaryRevenue']");
    public static By itemsSold = By.xpath("//p[text()='Items Sold']//parent::div//h3[@id='purchasesSummaryItems']");
    public static By avgTicketSize = By.xpath("//p[text()='Avg. Ticket Size']//parent::div//h3[@id='purchasesSummaryAverage']");
    public static By exportButton = By.xpath("//button[@id='exportPurchasesBtn']");

    // Table
    public static By tableRows = By.xpath("//table[@id='purchasesTable']//tbody//tr//td[3]");
    public static String tableActionBtn = "//table[@id='purchasesTable']//tbody//tr[%s]//td//button";
    // Use: driver.findElement(By.xpath(String.format(PurchasesPage.tableActionBtn, rowIndex))).click();

    // Modal
    public static By closeBtn = By.xpath("//div[@id='purchaseDetailsModal']//button[normalize-space(text())='Close']");
    public static By closeModalBtn = By.xpath("//div[@id='purchaseDetailsModal']//div[@class='modal-header']//button[@aria-label='Close']");
}
