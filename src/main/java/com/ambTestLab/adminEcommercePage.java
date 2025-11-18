package com.ambTestLab;

import RbcRoyalBank_Pages.AccountCreated_Page;
import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class adminEcommercePage  {
    private WebDriver driver;

    public adminEcommercePage(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger log = LogManager.getLogger(adminEcommercePage.class);
    // ---------------- Ecommerce Page ----------------
    public static By ecommercePage = By.xpath("//select[@id='viewSelector']"); // Dropdown

    // ---------------- Buttons ----------------
    public static By addButton = By.xpath("//div[@id='e-commerce-view']//button[@id='addProductBtn']");
    public static By exportButton = By.xpath("//div[@id='e-commerce-view']//button[@id='exportProductsBtn']");
    public static By editCardButton = By.xpath("//h5[normalize-space(text())='Mens Cotton Jacket']//parent::div//button[normalize-space(.)='Edit Product']");
    public static By deleteCardButton = By.xpath("//h5[normalize-space(text())='Mens Cotton Jacket']//parent::div//button[normalize-space(.)='Delete']");

    // ---------------- Edit Product Form ----------------
    public static By editTitleCheck = By.xpath("//div[@class='modal-header']//h5[normalize-space(text())='Edit Product']");
    public static By editProductName = By.xpath("//form[@id='editProductForm']//input[@id='editProductName']");
    public static By editProductPrice = By.xpath("//form[@id='editProductForm']//input[@id='editProductPrice']");
    public static By editProductStock = By.xpath("//form[@id='editProductForm']//input[@id='editProductStock']");
    public static By editProductRating = By.xpath("//form[@id='editProductForm']//input[@id='editProductRating']");
    public static By editProductImageUrl = By.xpath("//form[@id='editProductForm']//input[@id='editProductImage']");
    public static By saveChangesButton = By.xpath("//div[@class='modal-footer']//button[@id='saveProductBtn']");
    public static By cancelChangesButton = By.xpath("//h5[normalize-space(text())='Edit Product']//parent::div[@class='modal-header']//following-sibling::div//button[normalize-space(text())='Cancel']");

    // ---------------- Add Product Form ----------------
    public static By addTitleCheck = By.xpath("//div[@class='modal-header']//h5[normalize-space(text())='Add New Product']");
    public static By addProductName = By.xpath("//form[@id='addProductForm']//input[@id='addProductName']");
    public static By addDescription = By.xpath("//form[@id='addProductForm']//input[@id='addProductDescription']");
    public static By addProductPrice = By.xpath("//form[@id='addProductForm']//input[@id='addProductPrice']");
    public static By addProductStock = By.xpath("//form[@id='addProductForm']//input[@id='addProductStock']");
    public static By addCategory = By.xpath("//form[@id='addProductForm']//input[@id='addProductCategory']");
    public static By addProductRating = By.xpath("//form[@id='addProductForm']//input[@id='addProductRating']");
    public static By addProductImageUrl = By.xpath("//form[@id='addProductForm']//input[@id='addProductImage']");
    public static By addProductSaveButton = By.xpath("//h5[normalize-space(text())='Add New Product']//parent::div[@class='modal-header']//following-sibling::div//button[@id='saveNewProductBtn']");
    public static By cancelAddButton = By.xpath("//h5[normalize-space(text())='Add New Product']//parent::div[@class='modal-header']//following-sibling::div//button[normalize-space(text())='Cancel']");

    // ---------------- Verify Added Card ----------------
    public static By cardTitleVerify = By.xpath("//div[contains(@class,'card product-card')]//h5[@class='card-title']");



    public void checkingTheEcommercePage() {
        try {
            log.info("🔍 Waiting for the E-Commerce page element to be visible...");
            WebElementUtility.waitForElementVisible(driver, ecommercePage, 10);

            log.info("🔹 Hovering and blinking on the E-Commerce page element...");
            WebElementUtility.hoverWithBlink(driver, ecommercePage);

            log.info("✔ E-Commerce page element is visible and highlighted successfully.");
        } catch (Exception e) {
            log.error("❌ Error while checking the E-Commerce page element: {}", e.getMessage(), e);
            throw e; // or use Assert.fail() if inside a TestNG test
        }
    }

    public void checkingAddProductDetail () {
        try {
            log.info("🔍 Hovering over the E-Commerce page...");
            WebElementUtility.hoverWithBlink(driver, ecommercePage);

            log.info("⏳ Waiting for the 'Add' button to be clickable...");
            WebElementUtility.waitForPageLoad(driver,10);
            WebElementUtility.JSclickElement(driver, addButton);

            log.info("🔍 Waiting for 'Add New Product' modal title to be visible...");
            WebElementUtility.waitForElementVisible(driver, addTitleCheck, 5);
            log.info("🔹 Hovering and blinking on the 'Add New Product' modal title...");
            WebElementUtility.hoverWithBlink(driver, addTitleCheck);

            log.info("🔍 Waiting for 'Product Name' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addProductName, 3);
            WebElementUtility.hoverWithBlink(driver, addProductName);

            log.info("🔍 Waiting for 'Description' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addDescription, 3);
            WebElementUtility.hoverWithBlink(driver, addDescription);

            log.info("🔍 Waiting for 'Price' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addProductPrice, 3);
            WebElementUtility.hoverWithBlink(driver, addProductPrice);

            log.info("🔍 Waiting for 'Stock' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addProductStock, 3);
            WebElementUtility.hoverWithBlink(driver, addProductStock);

            log.info("🔍 Waiting for 'Category' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addCategory, 3);
            WebElementUtility.hoverWithBlink(driver, addCategory);

            log.info("🔍 Waiting for 'Rating' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addProductRating, 3);
            WebElementUtility.hoverWithBlink(driver, addProductRating);

            log.info("🔍 Waiting for 'Image URL' field and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addProductImageUrl, 3);
            WebElementUtility.hoverWithBlink(driver, addProductImageUrl);

            log.info("🔍 Waiting for 'Save' button and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, addProductSaveButton, 3);
            WebElementUtility.hoverWithBlink(driver, addProductSaveButton);

            log.info("🔍 Waiting for 'Cancel' button and highlighting it...");
            WebElementUtility.waitForElementVisible(driver, cancelAddButton, 3);
            WebElementUtility.hoverWithBlink(driver, cancelAddButton);

            log.info("🖱 Clicking on 'Cancel' button to close the Add Product form...");
            WebElementUtility.clickElement(driver, cancelAddButton);

            log.info("✔ Successfully hovered, blinked, and interacted with all elements in Add Product form.");

        } catch (Exception e) {
            log.error("❌ Error while hovering/blinking Add Product form elements: {}", e.getMessage(), e);
            throw e; // or Assert.fail() if used in a TestNG test
        }
    }

}
