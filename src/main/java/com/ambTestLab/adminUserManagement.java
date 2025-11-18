package com.ambTestLab;

import RbcRoyalBank_Pages.AccountCreated_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class adminUserManagement {
    private WebDriver driver;

    public adminUserManagement(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(adminUserManagement.class);

    // -------------------------------
    // Default Page Verification
    // -------------------------------
    public static By titleUserManagement = By.xpath("//div[@id='users-page']//h2[normalize-space(.)='User Management']");
    public static By noRegisterCheck = By.xpath("//div[@id='usersCardsView']//div[contains(text(), 'No registered users found.')]");
    public static By noUserFoundTable = By.xpath("//div[@id='usersTableView']//td[normalize-space(text())='No users found']");

    // -------------------------------
    // View Buttons
    // -------------------------------
    public static By cardViewButton = By.xpath("//div[@id='users-page']//button[@id='toggleUsersView']");
    public static By exportUsersButton = By.xpath("//div[@id='users-page']//button[@id='exportUsersBtn']");
}
