package RbcRoyalBank_Pages;

import Utility.BrowserUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import Utility.BasePage;
import Utility.WebElementUtility;

public class Signup_Page extends BasePage{
	
private static final Logger log = LogManager.getLogger(Home_Pages.class);
	
	public static By AccountInformation = By.xpath("//b[text()='Enter Account Information']");
	public static By Mr_redioButton = By.xpath("//input[@value='Mr']//ancestor::div[@class='radio-inline']");
	public static By PasswordTextBox = By.xpath("//input[@id='password']");
	public static By Date_DropDown = By.xpath("//select[@id='days']");
	public static By Month_dropDown = By.xpath("//select[@id='months']");
	public static By Years_dropDown = By.xpath("//select[@id='years']");
	public static By FristNameTextBox = By.xpath("//input[@id='first_name']");
	public static By LastNameTextBox = By.xpath("//input[@id='last_name']");
	public static By AddersTextBox = By.xpath("//input[@data-qa='address']");
	public static By Country_dropDown = By.xpath("//select[@id='country']");
	public static By StateTextBox = By.xpath("//input[@data-qa='state']");
	public static By CityTextBox = By.xpath("//input[@data-qa='city']");
	public static By ZipcodeTextBox = By.xpath("//input[@data-qa='zipcode']");
	public static By MoblieNumberTextBox = By.xpath("//input[@data-qa='mobile_number']");
	public static By CreatAccountButton = By.xpath("//button[@data-qa='create-account']");
	
	
	
	public void checkTheTitleOfThePage()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait check the title of the page ");
		String titel = WebElementUtility.getTextPageTitle(driver);
		Assert.assertEquals(titel,"Automation Exercise - Signup");
	}
	
	public void EnterAccountInformation()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the element Account Information display ");
		WebElementUtility.waitForElementVisible(driver, AccountInformation,10);
	}
	
	public void clickOnTheMr_RedioButton() 
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the Mr redio button click  ");
		WebElementUtility.clickElement(driver, Mr_redioButton );
	}
	
	public void EnterPassword() 
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait for the Enter the password ");
		WebElementUtility.sendkeysToElement(driver, PasswordTextBox ,"1234567890");
	}
	
	public void SelectDateOption() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the select the date option ");
		WebElementUtility.selectDropdownByVisibleText(driver, Date_DropDown,"14");
	}
	
	public void SelectMonthOption() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the select the month option ");
		WebElementUtility.selectDropdownByVisibleText(driver, Month_dropDown ,"October");
	}
	
	public void SelectYearsOption() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the select the yearS option ");
		WebElementUtility.selectDropdownByVisibleText(driver, Years_dropDown ,"1999");
	}
	
	public void EnterFirstName()
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the enter the firstname ");
		WebElementUtility.mouseHoverAndClick(driver, FristNameTextBox );
		WebElementUtility.implicitWait(driver,5);
		WebElementUtility.enterText(driver, FristNameTextBox, "praveen");
	}
	
	public void EnterLastName() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the enter the lastName");
		WebElementUtility.mouseHoverAndClick(driver, LastNameTextBox );
		WebElementUtility.enterText(driver,LastNameTextBox,"kumar");
	}
	
	public void EnterAdders() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("driver wait the enter the Adders ");
		WebElementUtility.mouseHoverAndClick(driver, AddersTextBox );
		WebElementUtility.enterText(driver, AddersTextBox ,"2/55,kphb,hmt Hills");
	}
	
	public void SelectCountry() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the select the country ");
		WebElementUtility.mouseHoverAndClick(driver, Country_dropDown );
		WebElementUtility.selectDropdownByVisibleText(driver, Country_dropDown ,"India");
	}
	
	public void EnterState() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the enter the state  ");
		WebElementUtility.mouseHoverAndClick(driver, StateTextBox );
		WebElementUtility.enterText(driver, StateTextBox ,"TS");
	}
	
	public void EnterCity() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the enter the city ");
		WebElementUtility.mouseHoverAndClick(driver, CityTextBox );
		WebElementUtility.enterText(driver, CityTextBox ,"Hyderbad");
	}
	
	public void EnterZipcode() 
	{
//		BrowserUtility.closeExtraTabs(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the enter the ZipCode ");
		WebElementUtility.mouseHoverAndClick(driver, ZipcodeTextBox );
		WebElementUtility.enterText(driver, ZipcodeTextBox ,"5000001");
	}
	
	public void EnterMoblieNumber() 
	{
//		BrowserUtility.closeBrowser(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,5);
		log.info("driver wait the moblie Number ");
		WebElementUtility.mouseHoverAndClick(driver, MoblieNumberTextBox );
		WebElementUtility.enterText(driver, MoblieNumberTextBox ,"1234567890");
	}
	
	public void clickCreatAccountButton() 
	{
		BrowserUtility.closeAdsIfPresent(driver);
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("driver wait the click on the creat Account button ");
		WebElementUtility.mouseHoverAndClick(driver, CreatAccountButton );
	}
	
}
