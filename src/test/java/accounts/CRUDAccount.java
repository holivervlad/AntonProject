package accounts;

import base.BaseTest;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.accounts.AccountsPage;
import pages.accounts.CreateNewAccountsPage;
import pages.HomePage;
import pages.LogInPage;
import pages.accounts.EditAccountPage;

public class CRUDAccount extends BaseTest {
    public LogInPage logInPage;
    public HomePage homePage;
    public AccountsPage accountsPage;
    public CreateNewAccountsPage createNewAccountsPage;
    public UserData userData;
    public EditAccountPage editAccountPage;


    @Test
    public void updateAccountName() {
        logInPage = base.openPlayGroundPage();
        accountsPage = logInPage.logInPlayGround(UserData.SALES_USER_EMAIL, UserData.SALES_USER_PASSWORD)
                .openAccountsPage()
                .openAccount("test Account")
                .OpenEditAccountPage()
                .updateAccountName("Hello World")
                .returnToAccountsPage();
        Assert.assertTrue(accountsPage.isAccountAvailable("Hello World"), "Account should be changed");

    }
        @AfterMethod
                public void afterMethodActions() throws InterruptedException {
        accountsPage
                .openAccount("Hello World")
                .OpenEditAccountPage()
                .returnOriginalNameOfAccount("test Account");
            Assert.assertTrue(accountsPage.isAccountAvailable("test Account"), "Account should be changed");
    }
}
