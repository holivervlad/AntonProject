package pages.accounts;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;

public class EditAccountPage extends BasePage {

    AccountsPage accountsPage;
    HomePage homePage;

    @FindBy(xpath = "//div[starts-with(@class,'modal-container')]//span[text() = 'Account Name']/../..//input")
    private WebElement accountNameField;

    @FindBy(xpath = "//button[@title = 'Save']")
    private WebElement saveButton;

    public AccountsPage updateAccountName(String newAccountName) {
        waitUntilLoading(accountNameField);
        accountNameField.clear();
        accountNameField.sendKeys(newAccountName);
        waitUntilLoading(saveButton);
        saveButton.click();
        return new AccountsPage();
    }

    public AccountsPage returnOriginalNameOfAccount(String oldAccountName) {
        accountNameField.clear();
        accountNameField.sendKeys(oldAccountName);
        waitUntilLoading(saveButton);
        saveButton.click();
        return new AccountsPage();
    }
}
