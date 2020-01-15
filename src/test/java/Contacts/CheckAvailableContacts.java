package Contacts;

import base.BaseTest;
import base.Tools;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.ContactPage;
import pages.HomePage;
import pages.LogInPage;

public class CheckAvailableContacts extends BaseTest {
    LogInPage logInPage;
    ContactPage contactPage;
    HomePage homePage;


    @Test
    public void checkThatListOfContactCreated() {
        logInPage = base.openPlayGroundPage();
        homePage = logInPage.logInPlayGround(UserData.SALES_USER_EMAIL, UserData.SALES_USER_PASSWORD);
        homePage.openContactListView()
                .openContactListViewFromContact()
                .openAllContactsListView();
                //.isSpecialContactsDisplay("test");
        Assert.assertTrue(contactPage.isSpecialContactsDisplay("test"));
    }
}
