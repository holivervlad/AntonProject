package base;

import configurationManager.BaseConfiguration;
import data.UserData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.LogInPage;
import pages.accounts.AccountsPage;

public class Base {
    private static String originUrl = "https://curious-moose-50xavl-dev-ed.my.salesforce.com";
    public LogInPage openPlayGroundPage() {
        BaseConfiguration.getDriver().get(originUrl);
        return new LogInPage();
    }


}
