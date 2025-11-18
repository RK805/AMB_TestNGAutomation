package com.ambTestLab;

import Utility.AdminConfigReader;

import Utility.WebElementUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class loginPage   {

    private WebDriver driver;

    // Constructor receives driver from test
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

        private static final Logger log = LogManager.getLogger(loginPage.class);

        public static By loginButton1 = By.xpath("//div[@class='container']//span[normalize-space()='Log In']");
        // -------------------------------
        // Email & Password Login
        // -------------------------------
        public static By emailInput = By.xpath("//form[@id='loginForm']//input[@id='email']");
        public static By passwordInput = By.xpath("//form[@id='loginForm']//input[@id='password']");
        public static By loginButton = By.xpath("//form[@id='loginForm']//button[@type='submit']");

        // -------
        // verification
        public static By verificationEnterAdminFiled = By.xpath("//div[@role='status']//div[text()='User not found']");
        public static By verificationEnterAdminSuccessful = By.xpath("//div[@role='status']//div[contains(text(),'Admin login successful. Redirecting')]");
        // -------------------------------
        // Tabs
        // -------------------------------
        public static By emailsTab = By.xpath("//ul[@id='loginTabs']//button[@id='password-tab']");
        public static By passwordTab = By.xpath("//ul[@id='loginTabs']//button[@id='otp-tab']");

        // -------------------------------
        // OTP Login
        // -------------------------------
        public static By emailForOtpInput = By.xpath("//form[@id='otpLoginForm']//input[@id='otpEmail']");
        public static By sendOtpButton = By.xpath("//form[@id='otpLoginForm']//button[@id='sendOtpBtn']");
        public static By verifyOtpButton = By.xpath("//form[@id='otpLoginForm']//button[@id='verifyOtpBtn']");
        public static By resetOtpButton = By.xpath("//form[@id='otpLoginForm']//button[@id='resendOtpBtn']");

        public static By otpInput1 = By.xpath("//form[@id='otpLoginForm']//input[@id='otp1']");
        public static By otpInput2 = By.xpath("//form[@id='otpLoginForm']//input[@id='otp2']");
        public static By otpInput3 = By.xpath("//form[@id='otpLoginForm']//input[@id='otp3']");
        public static By otpInput4 = By.xpath("//form[@id='otpLoginForm']//input[@id='otp4']");

        // -------------------------------
        // Register Link
        // -------------------------------
        public static By registerLink = By.xpath("//div[contains(@class,'login-container')]//a[@href='/register']");

        public void clickOnTheLoginButton() {
           log.info("implicit wait will add the driver");
           WebElementUtility.implicitWait(driver,10);
           log.info("driver scroll to the login Button");
           WebElementUtility.waitForElementVisible(driver,loginButton1,10);
           WebElementUtility.scrollToElement(driver, loginButton1);
           log.info("driver will click on the login button ");
           WebElementUtility.clickElement(driver,loginButton1);
        }

        public void enterTheLoginDetails (){
          String id= AdminConfigReader.getProperty("adminId");
          String password = AdminConfigReader.getProperty("adminPassword");
          WebElementUtility.waitForElementClickable(driver, emailInput,5);
          WebElementUtility.sendkeysToElement(driver,emailInput,id);
          WebElementUtility.sendkeysToElement(driver,passwordInput,password);
          WebElementUtility.JSclickElement(driver,loginButton);

            boolean success = WebElementUtility.isElementDisplayed(driver, verificationEnterAdminSuccessful);
            boolean failed  = WebElementUtility.isElementDisplayed(driver, verificationEnterAdminFiled);

            if (success) {
                log.info("The admin ID and password are correct.");
            }
            else if (failed) {
                log.info("The admin ID and password are wrong.");
            }
            else {
                log.info("No success or failure message appeared.");
            }
        }
    }
