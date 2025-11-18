package com.ambTestLab;

import RbcRoyalBank_Pages.AccountCreated_Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class adminMutualFundsPage {

    private WebDriver driver;

    public adminMutualFundsPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(AccountCreated_Page.class);

    // ---------------- Buttons ----------------
    public static By addFundButton = By.xpath("//div[@id='mutual-funds-data-page']//button[@id='addFundBtn']");
    public static By searchBar = By.xpath("//div[@id='mutual-funds-data-page']//input[@id='mutualFundsSearch']");
    public static By exportButton = By.xpath("//div[@id='mutual-funds-data-page']//button[@id='exportFundsBtn']");
    public static By importButton = By.xpath("//div[@id='mutual-funds-data-page']//label[normalize-space(.)='Import']");
    public static By editButton = By.xpath("//h5[normalize-space(text())='Emily Johnson']//ancestor::div[@class='fund-card-body']//button[normalize-space(text())='Edit']");
    public static By deleteButton = By.xpath("//h5[normalize-space(text())='Emily Johnson']//ancestor::div[@class='fund-card-body']//button[normalize-space(text())='Delete']");
    public static By prevButton = By.xpath("//ul[@id='mutualFundsPagination']//a[normalize-space(.)='Prev']");
    public static By nxtButton = By.xpath("//ul[@id='mutualFundsPagination']//a[normalize-space(.)='Next']");

    // ---------------- Edit Fund Form ----------------
    public static By editTitle = By.xpath("//form[@id='fundForm']//h5[@id='fundModalTitle']"); // to verify text "Edit Fund"
    public static By editFundName = By.xpath("//form[@id='fundForm']//input[@id='fundNameInput']");
    public static By editFundCode = By.xpath("//form[@id='fundForm']//input[@id='fundCodeInput']");
    public static By editCategoryDropDown = By.xpath("//form[@id='fundForm']//select[@id='fundCategoryInput']");
    public static By editImage = By.xpath("//form[@id='fundForm']//input[@id='fundImageInput']");
    public static By editOfferPrice = By.xpath("//form[@id='fundForm']//input[@id='fundPriceInput']");
    public static By editRiskLevel = By.xpath("//form[@id='fundForm']//select[@id='fundRiskInput']");
    public static By updateFund = By.xpath("//form[@id='fundForm']//button[@id='saveFundBtn']");

    // ---------------- Add Fund Form ----------------
    public static By addTitle = By.xpath("//form[@id='fundForm']//h5[@id='fundModalTitle']"); // to verify text "Add Fund"
    public static By addFundName = By.xpath("//form[@id='fundForm']//input[@id='fundNameInput']");
    public static By addFundCode = By.xpath("//form[@id='fundForm']//input[@id='fundCodeInput']");
    public static By addCategoryDropDown = By.xpath("//form[@id='fundForm']//select[@id='fundCategoryInput']");
    public static By addImage = By.xpath("//form[@id='fundForm']//input[@id='fundImageInput']");
    public static By addOfferPrice = By.xpath("//form[@id='fundForm']//input[@id='fundPriceInput']");
    public static By addRiskLevel = By.xpath("//form[@id='fundForm']//select[@id='fundRiskInput']");
    public static By addFundNav = By.xpath("//form[@id='fundForm']//input[@id='fundNavInput']");
    public static By addOriginalPrice = By.xpath("//form[@id='fundForm']//input[@id='fundOriginalPriceInput']");
    public static By addYearReturn = By.xpath("//form[@id='fundForm']//input[@id='fundReturn1YInput']");
    public static By add3YearReturn = By.xpath("//form[@id='fundForm']//input[@id='fundReturn3YInput']");
    public static By add5YearReturn = By.xpath("//form[@id='fundForm']//input[@id='fundReturn5YInput']");
    public static By addFundHouse = By.xpath("//form[@id='fundForm']//input[@id='fundVendorInput']");
    public static By location = By.xpath("//form[@id='fundForm']//input[@id='fundLocationInput']");
    public static By saveButton = By.xpath("//form[@id='fundForm']//button[@id='saveFundBtn']");


}
