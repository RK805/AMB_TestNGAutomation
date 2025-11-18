package RbcRoyalBank_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.By;


import Utility.WebElementUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home_Pages {

	private WebDriver driver;

	// Constructor receives driver from test
	public Home_Pages(WebDriver driver) {
		this.driver = driver;
	}

	private static final Logger log = LogManager.getLogger(Home_Pages.class);
	
	public static By loginButton = By.xpath("//a[contains(@href,'login')]");
	public static By deleteAccount = By.xpath("//a[contains(@href,'delete_account')]");
	
	
	public void checkTheTitleOfThePage()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait check the title of the page ");
		String titel = WebElementUtility.getTextPageTitle(driver);
		Assert.assertEquals(titel,"Automation Exercise");
	}
	
	public void clickLoginButton()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("driver wait the element for click login button ");
		WebElementUtility.clickElement(driver, loginButton);
	}

	public void clickDeleteAccount()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the element for click delete account  ");
		WebElementUtility.clickElement(driver, deleteAccount);
	}
}
