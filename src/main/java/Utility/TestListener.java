package Utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        ExtentTestManager.getTest().log(Status.INFO, "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        // Get WebDriver from the test class instance using reflection
        Object testClass = result.getInstance();
        WebDriver driver = null;
        try {
            driver = (WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Save screenshot inside test-output/screenshots/
        String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName, screenshotDir);

        String relativePath = "screenshots/" + testName + ".png";

        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        try {
            ExtentTestManager.getTest().fail("Screenshot:",
                    MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed to attach screenshot: " + e.getMessage());
        }

        Reporter.log("<a href='" + relativePath + "' target='_blank'>Screenshot</a>");
        Reporter.log("<br><img src='" + relativePath + "' height='200' width='200'/><br>");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}
