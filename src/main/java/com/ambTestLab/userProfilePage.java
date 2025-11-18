package com.ambTestLab;

import org.openqa.selenium.By;

public class userProfilePage {

    // ---------------- Profile Tab & Edit ----------------
    public static By profileTab = By.xpath("//div[@id='navbarNav']//a[contains(normalize-space(.),'Dashboard')]");
    public static By editProfileButton = By.xpath("//div[@class='card - header']//button[normalize-space(.)='Edit Profile']");
    public static By editFirstName = By.xpath("//form[@id='editProfileForm']//input[@id='editFirstName']");
    public static By editLastName = By.xpath("//form[@id='editProfileForm']//input[@id='editLastName']");
    public static By editMobileNo = By.xpath("//form[@id='editProfileForm']//input[@id='editMobile']");
    public static By editEmail = By.xpath("//form[@id='editProfileForm']//input[@id='editEmail']");
    public static By editPassword = By.xpath("//form[@id='editProfileForm']//following-sibling::input[@id='editPassword']");
    public static By visibilityButton = By.xpath("//form[@id='editProfileForm']//button[contains(@aria-label,'password visibility')]");
    public static By saveChangeButton = By.xpath("//div[contains(@class,'modal-footer')]//button[normalize-space(.)='Save Changes']");

    // ---------------- Verification of Changes ----------------
    public static By fullName = By.xpath("//div[@class='card-body']//strong[@id='userFullName']");
    public static By mobileNumber = By.xpath("//div[@class='card-body']//strong[@id='userMobile']");
    public static By emailID = By.xpath("//div[@class='card-body']//strong[@id='userEmailDetail']");

}
