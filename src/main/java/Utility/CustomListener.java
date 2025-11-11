package Utility;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(CustomListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getName());
        logger.error("Error Details:", result.getThrowable());
    }
}

