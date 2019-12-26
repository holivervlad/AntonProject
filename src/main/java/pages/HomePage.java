package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.accounts.AccountsPage;

public class HomePage extends BasePage {
    ContactPage contactPage;

    @FindBy(xpath = "//button[@title = 'Show Navigation Menu']")
    private WebElement tabDropDown;

    @FindBy(xpath = "//span[@class='slds-media__body']//span[text() = 'Accounts']")
    private WebElement accountsTab;

    @FindBy(xpath = "//a[@title = 'Contacts']/span[2]")
    private WebElement contactsTab;

    public AccountsPage openAccountsPage() {
//        waitUntilLoading(tabDropDown);
//        tabDropDown.click();
//        waitUntilLoading(accountsTab);
//        accountsTab.click();
        return new AccountsPage();
    }

    public ContactPage openContactListView() {
        tabDropDown.click();
        contactsTab.click();
        return new ContactPage();
    }

}

