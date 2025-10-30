package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionLibrary {
    public WebDriver driver;

    public FunctionLibrary(WebDriver driver)
    {
        driver = new FirefoxDriver();
        this.driver=driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
