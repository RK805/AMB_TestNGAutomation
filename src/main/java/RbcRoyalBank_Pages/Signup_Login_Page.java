package RbcRoyalBank_Pages;

import Utility.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.By;
import Utility.WebElementUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Signup_Login_Page  {

	private WebDriver driver;

	public Signup_Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	private static final Logger log = LogManager.getLogger(Signup_Login_Page.class);
	
	public static By signOption = By.xpath("//h2[text()='New User Signup!']");
	public static By UserNameTextBox = By.xpath("//input[@placeholder='Name']");
	public static By EmailTextBox = By.xpath("//input[@placeholder='Email Address' and @data-qa='signup-email']");
	public static By SignButton = By.xpath("//button[@data-qa='signup-button']");
	
	public void checkTheTitleOfThePage()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait check the title of the page ");
		String titel = WebElementUtility.getTextPageTitle(driver);
		Assert.assertEquals(titel,"Automation Exercise - Signup / Login");
	}
	
	public void signOption_Dispaly()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait for the signOption is dispaly or not ");
		WebElementUtility.waitForElementVisible(driver, signOption,10);
	}
	
	public void EnterTheUserName()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait for enter the Username ");
		WebElementUtility.sendkeysToElement(driver, UserNameTextBox,"praveen");
	}
	
	public String  EnterTheEmail()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait for enter the email ");
		String randomEmail = RandomUtils.getRandomEmail();
		WebElementUtility.sendkeysToElement(driver, EmailTextBox ,randomEmail);
		return randomEmail;
	}
	
	public void clickOnTheSignButton() 
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait for click the Sign Button ");
		WebElementUtility.clickElement(driver,SignButton );
	}
	
}
