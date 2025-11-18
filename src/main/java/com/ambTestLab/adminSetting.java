package com.ambTestLab;

import RbcRoyalBank_Pages.AccountCreated_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class adminSetting {
    private WebDriver driver;

    public adminSetting(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(adminSetting.class);
    // -------------------------------
    // Page Header
    // -------------------------------
    public static By settingHeader = By.xpath("//div[@id='settings-page']//h2[normalize-space(text())='Admin Settings']");

    // -------------------------------
    // Change Admin Credentials
    // -------------------------------
    public static By changeAdminEmail = By.xpath("//form[@id='adminSettingsForm']//input[@id='adminEmail']");
    public static By changeAdminName = By.xpath("//form[@id='adminSettingsForm']//input[@id='adminNameInput']");
    public static By updateButton = By.xpath("//form[@id='adminSettingsForm']//button[normalize-space(text())='Update Settings']");

    // -------------------------------
    // Data Management
    // -------------------------------
    public static By exportButton = By.xpath("//div[@class='card-body']//button[@id='exportAllDataBtn']");
    public static By clearButton = By.xpath("//div[@class='card-body']//button[@id='clearAllDataBtn']");
}