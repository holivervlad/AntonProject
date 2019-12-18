package accounts;

import base.BaseTest;
import base.Tools;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.AccountsPage;
import pages.accounts.CreateNewAccountsPage;
import pages.HomePage;
import pages.LogInPage;
import sun.jvm.hotspot.tools.Tool;

public class CreateNewAccount extends BaseTest {
    public LogInPage logInPage;
    public HomePage homePage;
    public AccountsPage accountsPage;
    public CreateNewAccountsPage createNewAccountsPage;
    public UserData userData;

    private String accountName;

    @Test
    public void createAccount() {
        accountName = Tools.getFakeName("Account");
        logInPage = base.openPlayGroundPage();
        accountsPage = logInPage.logInPlayGround(UserData.SALES_USER_EMAIL, UserData.SALES_USER_PASSWORD)
                .openAccountsPage()
                .clickOnNewAccountButton()
                .createNewAccount(accountName, Tools.getFakeSlaSerialNumber());
        Assert.assertTrue(accountsPage.isAccountCreated(accountName),
                String.format("Account with name'%s' should be created.", accountName));

    }
}


