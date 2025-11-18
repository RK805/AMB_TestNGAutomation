package com.ambTestLab;

import org.openqa.selenium.By;

public class userPortfolioPage {

    // ---------------- Verification ----------------
    public static By toVerifyCartCount = By.xpath("//span[normalize-space(text())='Total funds in portfolio']//parent::div//div[@id='summaryCount']");
    public static By summaryTotal = By.xpath("//span[normalize-space(text())='Combined portfolio price']/parent::div//div[@id='summaryTotal']");
    public static By summarySavings = By.xpath("//span[normalize-space(text())='Total savings vs MRP']/parent::div//div[@id='summarySavings']");
    public static By productCardName = By.xpath("//div[@class='doc - pro - name']//span[not(preceding-sibling::span)]");
    public static By deleteButton = By.xpath("//button[normalize-space(.)='Delete']");

    // ---------------- To Buy ----------------
    public static By proceedToBuyButton = By.xpath("//button[normalize-space(.)='Proceed to Buy']");
    public static By securePayment = By.xpath("//button[normalize-space(.)='Complete Secure Payment']");
    public static By returnToPortfolio = By.xpath("//button[contains(normalize-space(text()), 'Return to Portfolio')]");

    // ---------------- Verify Payment ----------------
    public static By toVerifyPaymentSuccessful = By.xpath("//div[@class='success-card']//h1[normalize-space(text())='Payment Successful']");
    public static By viewPurchaseSummary = By.xpath("//div[@class='success-card']//a[normalize-space(text())='View Purchase Summary']");
    public static By reviewConfirm = By.xpath("//h3[normalize-space(text())='Review & Confirm']/following-sibling::span[@id='itemCount']");

    // ---------------- Purchase Summary Verification ----------------
    public static By verifyFunds = By.xpath("//div[@id='summaryMeta']//following-sibling::span[contains(normalize-space(text()), 'funds')]");
    public static By verifyNameOfProduct = By.xpath("//tbody[@id='summaryBody']//div");
    public static By verifySummaryInvested = By.xpath("//div[text()='Total Invested']//parent::div//div[@id='summaryInvested']");
    public static By verifySummarySavings = By.xpath("//div[text()='Savings vs Original']//parent::div//div[@id='summarySavings']");
    public static By verifySummaryReturns = By.xpath("//div[text()='Average 5Y Returns']//parent::div//div[@id='summaryReturns']");

    // ---------------- Return to Portfolio ----------------
    public static By toReturnPortfolio = By.xpath("//div[@class='container-fluid']//span[text()='Portfolio']");

}
