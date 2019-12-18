package base;

import configurationManager.BaseConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BaseConfiguration{
    public final Base base = new Base();

    @BeforeSuite(alwaysRun = true)
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }


    @AfterSuite(alwaysRun = true)
    protected void afterSuiteActions() {
        //BaseConfiguration.getDriver().quit();
    }
}
