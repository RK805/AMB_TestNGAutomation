package RbcRoyalBank_Pages;

import Utility.BasePage;
import Utility.WebElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RbcRoyal_personalLoansPage extends BasePage
{

    public static By personalLoansLink = By.xpath("//h2[@class='text-center mar-b']");
    public static By borrowingReasonDropdown = By.xpath("//div[@class='select-wpr required']/select");
    public static By borrowingReasonOptions = By.xpath("//div[@class='select-wpr required']/select/option"); //Major Purchase
    public static  By borrowingloanAmount = By.xpath("//div[contains(@style,'padding-left')]//input[@placeholder='Enter amount']");
    public static By getResultsButton = By.xpath("//div[contains(@class,'grid-three-fourths')]//a[text()='Get Results']");
    public  static  By borrowingAmount = By.xpath("//label[normalize-space()='How much would you like to borrow:']");
    public static By interstRate = By.xpath("//input[@id='calRate']   ");
    public static By loanButton = By.xpath("//ul[@id='calKind']/li/a[text()='Loan']");
    public static By repaymentPeriod = By.xpath("//div[contains(@class,'input-wpr required')]/following::select[@id='calPeriod']");
    public static By repaymentPeriodOption = By.xpath("//div[contains(@class,'input-wpr required')]/following::select[@id='calPeriod']/option");
    public static By monthlyPayment = By.xpath("//div[contains(@class,'input-wpr required')]/following::select[@id='calFrequency']");
    public static By monthlyPaymentOption = By.xpath("//div[contains(@class,'input-wpr required')]/following::select[@id='calFrequency']/option");
    public static By getRelust = By.xpath("//input[@id='get-results-btn']");
    public static By resultAmount = By.xpath("//p[contains(@class,'result-amount')]");


    public void clickBorrowingReasonDropdown() {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.scrollToElement(driver, personalLoansLink);
        WebElementUtility.clickElement(driver,borrowingReasonDropdown);
    }

    public void selectBorrowingReason(String reason) {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.ListOfElement(driver, borrowingReasonOptions, reason);
    }

    public void enterLoanAmount(String amount) {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.clickElement(driver, borrowingloanAmount);
        WebElementUtility.sendkeysToElement(driver, borrowingloanAmount, amount);
    }

    public void clickGetResultsButton() {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.JSclickElement(driver, getResultsButton);
    }

    public void enterInterestRate(String rate) {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.scrollToElement(driver, borrowingAmount);
        WebElementUtility.sendkeysToElement(driver, interstRate, rate);
    }

    public void clickLoanButton() {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.JSclickElement(driver, loanButton);
    }

    public void selectRepaymentPeriod() {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.clickElement(driver, repaymentPeriod);
    }
    public void selectRepaymentPeriodOption(String period) {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.ListOfElement(driver, repaymentPeriodOption, period);
    }
    public void selectMonthlyPayment(String payment) {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.clickElement(driver, monthlyPayment);
        WebElementUtility.ListOfElement(driver, monthlyPaymentOption, payment);
    }

    public void clickGetRelust() {
        WebElementUtility.implicitWait(driver, 10);
        WebElementUtility.JSclickElement(driver, getRelust);
    }

    public String getResultAmount() {
        WebElementUtility.implicitWait(driver, 10);
        String result = WebElementUtility.getElementText(driver, resultAmount);
        if(result=="$0.00")
        {
           WebElementUtility.waitForElementVisible(driver, resultAmount,10);
        }
        else
        {
            if (result.contains("Please enter a valid loan amount")) {
                System.out.println("Error message displayed: " + result);
            } else {
                System.out.println("Result Amount: "+ result);
            }
        }
        return result;
    }
}
