package com.ambTestLab;

import org.openqa.selenium.By;

public class fundsPage {

    public static By fundsTab = By.xpath("//div[@class='container-fluid']//a[text()='Funds']");
    public static By SIPCalculationsTab = By.xpath("//div[@class='container-fluid']//a[text()='SIP Calculations']");
    public static By dashboardTab = By.xpath("//div[@class='container-fluid']//a[text()='Dashboard']");
    public static By logoutTab = By.xpath("//div[@class='container-fluid']//a[text()='Logout']");
    public static By portfolioTab = By.xpath("//div[@class='container-fluid']//span[text()='Portfolio']");
    public static By mutualFundsTab = By.xpath("//div[@class='container-fluid']//a[text()='Mutual Funds']");
    public static By refreshBtn = By.xpath("//div//button[@id='refreshBtn']");
    public static By addButton = By.xpath("//a[text()='Emily Johnson']//ancestor::div[contains(@class,'doc-content flex-grow')]//button//span[text()='Add']");
    public static By buyNowButton = By.xpath("//a[text()='Emily Johnson']//ancestor::div[@class='doc-content flex-grow-1']//button//span[text()='Buy Now']");
    public static By prevButton = By.xpath("//nav[@aria-label='Page navigation']//li//a[text()='Prev']");
    public static By nextButton = By.xpath("//nav[@aria-label='Page navigation']//li//a[text()='Next']");
    public static By discoverFundsPage = By.xpath("//div[@class='page-heading']//h2[text()='Discover Funds']");
}
