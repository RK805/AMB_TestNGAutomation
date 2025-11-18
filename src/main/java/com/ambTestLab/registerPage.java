package com.ambTestLab;

import org.openqa.selenium.By;

public class registerPage {
    // -------------------------------
    // Registration Form Fields
    // -------------------------------
    public static By firstName = By.xpath("//form[@id='registerForm']//input[@id='firstName']");
    public static By middleName = By.xpath("//form[@id='registerForm']//input[@id='middleName']");
    public static By lastName = By.xpath("//form[@id='registerForm']//input[@id='lastName']");
    public static By email = By.xpath("//form[@id='registerForm']//input[@id='email']");
    public static By password = By.xpath("//form[@id='registerForm']//input[@id='password']");
    public static By confirmPassword = By.xpath("//form[@id='registerForm']//input[@id='confirmPassword']");
    public static By mobileNumber = By.xpath("//form[@id='registerForm']//input[@id='mobile']");
    public static By location = By.xpath("//form[@id='registerForm']//input[@id='location']");
    public static By address = By.xpath("//form[@id='registerForm']//textarea[@id='address']");

    // -------------------------------
    // Buttons / Links
    // -------------------------------
    public static By registerButton = By.xpath("//form[@id='registerForm']//button[contains(text(),'Register')]");
    public static By goToLoginPage = By.xpath("//form[@id='registerForm']//a[contains(text(), 'Login')]");

}