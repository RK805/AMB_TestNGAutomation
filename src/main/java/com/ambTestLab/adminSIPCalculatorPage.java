package com.ambTestLab;

import RbcRoyalBank_Pages.AccountCreated_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class adminSIPCalculatorPage {

    private WebDriver driver;

    public adminSIPCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(adminSIPCalculatorPage.class);

    public static By SIPCalculatorDataTitleHead = By.xpath("//div[@id='sip-calculations-page']//h2[text()='SIP Calculator Data']");
    public static By monthlyInvestmentDistributionTitle = By.xpath("//div[@class='card']//h5[text()='Monthly Investment Distribution']");
    public static By monthlyInvestmentDistribution = By.xpath("//h5[text()='Monthly Investment Distribution']//ancestor::div[@class='card']//*[name()='g']//*[name()='rect']");
    public static By returnRateDistribution = By.xpath("//h5[text()='Return Rate Distribution']//ancestor::div[@class='card']//*[name()='g']//*[name()='path']");
    public static By returnRateDistributionTitle = By.xpath("//div[@class='card']//h5[text()='Return Rate Distribution']");
    public static By AllSIPCalculator = By.xpath("//div[@class='card']//h5[text()='All SIP Calculator']");
    public static By allSIPMonthlyAmounts = By.xpath("//table[@id='calculationsTable']//td[1]");
    public static By allSIPYears = By.xpath("//table[@id='calculationsTable']//td[2]");
    public static By allSIPReturn  = By.xpath("//table[@id='calculationsTable']//td[3]");
    public static By allSIPTotalInvested = By.xpath("//table[@id='calculationsTable']//td[4]");
    public static By allSIPFutureValue = By.xpath("//table[@id='calculationsTable']//td[5]");
    public static By allSIPEstimatedReturns = By.xpath("//table[@id='calculationsTable']//td[6]");
    public static By allSIPDate = By.xpath("//table[@id='calculationsTable']//td[7]");
    public static By exportDate = By.xpath("//div[@class='card']//button[@id='exportCalculationsBtn']");
    public static By loginButton = By.xpath("//div[@id='sidebar']//a[@id='logoutBtn']");

}

