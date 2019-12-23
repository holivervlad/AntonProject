package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.accounts.AccountsPage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@title = 'Show Navigation Menu']")
    private WebElement tabDropDown;

    @FindBy(xpath = "//span[@class='slds-media__body']//span[text() = 'Accounts']")
    private WebElement accountsTab;

    public AccountsPage openAccountsPage() {
//        waitUntilLoading(tabDropDown);
//        tabDropDown.click();
//        waitUntilLoading(accountsTab);
//        accountsTab.click();
        return new AccountsPage();
    }

}

