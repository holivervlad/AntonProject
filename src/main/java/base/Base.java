package base;

import configurationManager.BaseConfiguration;
import data.UserData;
import pages.LogInPage;

public class Base {
    private static String originUrl = "https://curious-moose-50xavl-dev-ed.my.salesforce.com";
    public LogInPage openPlayGroundPage() {
        BaseConfiguration.getDriver().get(originUrl);
        return new LogInPage();
    }
}
