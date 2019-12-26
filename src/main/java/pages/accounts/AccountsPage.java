package pages.accounts;

import base.BasePage;
import configurationManager.BaseConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class AccountsPage extends BasePage {

    @FindBy(xpath = "//div[@title = 'New']")
    private WebElement newAccountButton;

    @FindBy(xpath = "//div[@title = 'Import']")
    private WebElement importButton;

    @FindBy(xpath = "//a[@role = 'button'][@title = 'Select List View']")
    private WebElement listViewDropDown;

    @FindBy(xpath = "//li//span[text() = 'All Accounts']")
    private WebElement allAccountsListView;

    @FindBy (xpath = "//input[@name = 'Account-search-input']")
    private WebElement localSearch;

    @FindBy(xpath = "//span[@title = 'test']")
    private WebElement testAccount;

    @FindBy(xpath = "//div[@title = 'Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//tbody//tr//th")
    private List<WebElement> accountNames;

    @FindBy(xpath = "//button[@title = 'Show Navigation Menu']")
    private WebElement tabDropDown;

    @FindBy(xpath = "//a[@title = 'Accounts']/span[2]")
    private WebElement accountsTab;

CreateNewAccountsPage createNewAccountsPage;

    public CreateNewAccountsPage clickOnNewAccountButton () {
        waitUntilLoading(newAccountButton);
        newAccountButton.click();
        return new CreateNewAccountsPage();
    }

    public AccountsPage openAccount(String accountName) {
        driver.findElement(By.xpath("//a[text()='"+accountName+"']")).click();
        return new AccountsPage();
    }

    public EditAccountPage OpenEditAccountPage() {
        waitUntilLoading(editButton);
        editButton.click();
        return new EditAccountPage();
    }

    public Boolean isAccountPresentOnTheList(List<WebElement> elements, String accountName){
        for (WebElement element: elements) {
            if (element.findElement(By.xpath("//span[text()='"+accountName+"']"))
                    .isDisplayed())
                return true;
        }
        return false;
    }

    public Boolean isAccountAvailable(String accountName) {
        try {
            return BaseConfiguration.getDriver().findElement(By.xpath("//span[text()='" + accountName + "']"))
                    .isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public AccountsPage returnToAccountsPage() {
        waitUntilLoading(tabDropDown);
        tabDropDown.click();
        waitUntilLoading(accountsTab);
        accountsTab.click();
        return this;
    }

    public boolean isAccountCreated(String name) {
        try {
            return BaseConfiguration.getDriver().findElement(By.xpath("//span[@class = 'custom-truncate uiOutputText' and contains(text(), '"+name+"')]"))
                    .isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}