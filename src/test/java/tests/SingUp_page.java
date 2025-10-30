package tests;

import RbcRoyalBank_Pages.AccountCreated_Page;
import RbcRoyalBank_Pages.Home_Pages;
import RbcRoyalBank_Pages.Signup_Login_Page;
import RbcRoyalBank_Pages.Signup_Page;
import Utility.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;



public class SingUp_page extends BasePage{

	 private static final Logger log = LogManager.getLogger(SingUp_page.class);
	 
	  AccountCreated_Page accountCreated_Page;
	  Home_Pages home_Pages;
	  Signup_Login_Page signup_login_page;
	  Signup_Page signup_Page;
	  String email;



	    @Parameters({"browser"})
	    @BeforeClass
	    public void setUp(@Optional("chrome") String browser) {
	        log.info("Starting test setup");
	        initializeDriver(browser);
	    }
	    @Test
	    public void testGoogle() {
	        log.info("Opening loan website");
	        driver.get("https://automationexercise.com/");
	         String titel = driver.getTitle();
	        // Add your assertions here
	        log.info("Page title: " + getDriver().getTitle());
	        Assert.assertEquals(titel,"Automation Exercise");
	    }

		@Test(dependsOnMethods = {"testGoogle"})
	    public void signupAccount()
		{
			home_Pages = new Home_Pages();
			accountCreated_Page = new AccountCreated_Page();
			signup_login_page = new Signup_Login_Page();
			signup_Page = new Signup_Page();

			home_Pages.checkTheTitleOfThePage();
			home_Pages.clickLoginButton();
			signup_login_page.checkTheTitleOfThePage();
			signup_login_page.signOption_Dispaly();
			signup_login_page.EnterTheUserName();
			email = signup_login_page.EnterTheEmail();
			signup_login_page.clickOnTheSignButton();

		}

		@Test(dependsOnMethods = {"signupAccount","signupAccount"})
		public void EnterDitelas()
		{
			signup_login_page = new Signup_Login_Page();

			signup_Page.checkTheTitleOfThePage();
			signup_Page.EnterAccountInformation();
			signup_Page.clickOnTheMr_RedioButton();
			signup_Page.EnterPassword();
			signup_Page.SelectDateOption();
			signup_Page.SelectMonthOption();
			signup_Page.SelectYearsOption();
			signup_Page.EnterFirstName();
			signup_Page.EnterLastName();
			signup_Page.EnterAdders();
			signup_Page.SelectCountry();
			signup_Page.EnterState();
			signup_Page.EnterCity();
			signup_Page.EnterZipcode();
			signup_Page.EnterMoblieNumber();
			signup_Page.clickCreatAccountButton();
		}

		@Test(dependsOnMethods = {"signupAccount","EnterDitelas","EnterDitelas"})
		public void checkingCreation()
		{
			accountCreated_Page = new AccountCreated_Page();

			accountCreated_Page.checkTheTitleOfThePage();
			accountCreated_Page.CheckTheCreatAccountConfimMassage();
		}

		@Test(dependsOnMethods = {"signupAccount","EnterDitelas","EnterDitelas","checkingCreation"})
		public void deletingAccout()
		{
			home_Pages = new Home_Pages();

			home_Pages.clickDeleteAccount();
			accountCreated_Page.setCheckTheDeleteAccountConfimMassage();
		}
		@AfterClass
	    public void tearDown() {
	        log.info("Tearing down test");
	        quitDriver();
	    }
	    
}
