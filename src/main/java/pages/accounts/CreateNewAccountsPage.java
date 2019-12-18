package pages.accounts;

import base.BasePage;
import configurationManager.BaseConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.accounts.AccountsPage;

import javax.swing.*;
import java.util.NoSuchElementException;

public class CreateNewAccountsPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Account Name']/../..//input[@type = 'text']")
    private WebElement accountNameField;

    @FindBy(xpath = "//button[@title = 'Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[text() = 'Active']/../..//div[@class = 'uiMenu']")
    private WebElement activeDropDown;

    @FindBy(xpath = "//div[@class = 'select-options']//a[text() = 'Yes']")
    private WebElement chooseActiveinActiveDropDown;

    @FindBy(xpath = "//span[text() = 'SLA Expiration Date']/../..//input")
    private WebElement slaExpirationDateDropDownCalendar;

    @FindBy(xpath = "//td[@class='slds-is-today slds-is-selected uiDayInMonthCell']/span")
    private WebElement todaysDateInSlaExpirationDateDropDownCalendar;

    @FindBy(xpath = "//span[text() = 'SLA']/../..//div[@class = 'uiMenu']")
    private WebElement slaDropDown;

    @FindBy(xpath = "//li/a[@title = 'Gold']")
    private WebElement valueInTheSlaDropDown;

    @FindBy(xpath = "//span[text() = 'SLA Serial Number']/../..//input")
    private WebElement slaSerialNumberField;

    @FindBy(xpath = "//span[text() = 'Billing Street']/../..//textarea[@placeholder = 'Billing Street']")
    private WebElement billingStreetField;

    @FindBy(xpath = "//span[text() = 'Employees']")
    private WebElement employeesField;

    @FindBy(xpath = "//span[text() = 'Customer Priority']/../..//div[@class = 'uiMenu']")
    private WebElement customerPriorityDropDown;

    @FindBy(xpath = "//div[@id = 'brandBand_1']")
    private WebElement newAccountPopUp;

    public AccountsPage createNewAccount(String accountName, double slaSerialNumber) {
        waitUntilLoading(accountNameField);

        accountNameField.sendKeys(accountName);

        waitUntilLoading(activeDropDown);
        activeDropDown.click();
        waitUntilLoading(chooseActiveinActiveDropDown);
        waitUntilLoading(chooseActiveinActiveDropDown);
        chooseActiveinActiveDropDown.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(slaDropDown);
        actions.perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slaDropDown);
        waitUntilLoading(slaDropDown);
        slaDropDown.click();
        waitUntilLoading(valueInTheSlaDropDown);
        valueInTheSlaDropDown.click();
        slaExpirationDateDropDownCalendar.click();
        waitUntilLoading(todaysDateInSlaExpirationDateDropDownCalendar);
        todaysDateInSlaExpirationDateDropDownCalendar.click();
        waitUntilLoading(slaSerialNumberField);
        slaSerialNumberField.sendKeys(String.valueOf(slaSerialNumber));

        waitUntilLoading(saveButton);
        saveButton.click();
        return new AccountsPage();
    }


}
