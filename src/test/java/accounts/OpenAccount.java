package accounts;

import base.Base;
import base.BaseTest;
import data.UserData;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class OpenAccount extends BaseTest {
    public LogInPage logInPage;
    public HomePage homePage;

    @Test
    public void openAccount() {
        logInPage = base.openPlayGroundPage();
        homePage = logInPage.logInPlayGround(UserData.SALES_USER_EMAIL, UserData.SALES_USER_PASSWORD);
    }
}
