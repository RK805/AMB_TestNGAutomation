package RbcRoyalBank_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


import Utility.WebElementUtility;
import org.openqa.selenium.WebDriver;

public class AccountCreated_Page  {

	private WebDriver driver;

	public AccountCreated_Page(WebDriver driver) {
		this.driver = driver;
	}
	private static final Logger log = LogManager.getLogger(AccountCreated_Page.class);
	
    public static By CheckTheCreatAccountConfimMassage = By.xpath("//h2[@data-qa='account-created']//parent::div//a[text()='Continue']");
	public static By checkTheDeleteAccount = By.xpath("//h2[@data-qa='account-deleted']//parent::div//a[text()='Continue']");

	
    public void checkTheTitleOfThePage()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("Webdriver wait check the title of the page ");
		String titel = WebElementUtility.getTextPageTitle(driver);
//		Assert.assertEquals(titel,"Automation Exercise - Account Created");
	}
    
	public void CheckTheCreatAccountConfimMassage()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("driver wait the CheckTheCreatAccountConfimMassage element visible ");
		WebElementUtility.waitForElementVisible(driver, CheckTheCreatAccountConfimMassage,10);
		WebElementUtility.mouseHoverAndClick(driver,CheckTheCreatAccountConfimMassage);
	}

	public void setCheckTheDeleteAccountConfimMassage()
	{
		log.info("Webdriver wait for the impliciwait");
		WebElementUtility.implicitWait(driver,10);
		log.info("driver wait the checkTheDeleteAccount element visible ");
		WebElementUtility.waitForElementVisible(driver, checkTheDeleteAccount,10);
		WebElementUtility.mouseHoverAndClick(driver,checkTheDeleteAccount);
	}
}
