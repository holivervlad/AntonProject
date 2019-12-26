package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class ContactPage extends BasePage {
    BasePage basePage;

    @FindBy(xpath = "//div[text() = 'New']")
    private WebElement newButton;

    @FindBy(xpath = "//div[text() = 'Import']")
    private WebElement importButton;

    @FindBy(xpath = "//div[text() = 'Send List Email']")
    private WebElement sendListEmailButton;

    @FindBy(xpath = "//input[@name = 'Contact-search-input']")
    private WebElement localSearch;

    @FindBy(xpath = "//button[@title = 'Show Navigation Menu']")
    private WebElement listViewButton;

    @FindBy(xpath = "//button[@title='List View Controls']")
    private WebElement listViewControlsButton;

    @FindBy(xpath = "//button[@title='Display as Table']")
    private WebElement displayAsTableButton;

    @FindBy(xpath = "//button[@name = 'refreshButton']")
    private WebElement refreshButton;

    @FindBy(xpath = "//button[@name = 'inlineEditButton']")
    private WebElement inlineEditButton;

    @FindBy(xpath = "//a[@title = 'Contacts']/span[2]")
    private WebElement contactsTab;

    @FindBy(xpath = "//li//span[text() = 'All Contacts']")
    private WebElement allContactsListView;

    public ContactPage openAllContactsListView() {
        waitUntilLoading(listViewDropDown);
        listViewDropDown.click();
        waitUntilLoading(allContactsListView);
        allContactsListView.click();
        return new ContactPage();
    }

    public boolean isSpecialContactsDisplay(String nameOfContact) {
        waitUntilLoading(allContactsListView);
        return
        allElementsOfCurrentListView.stream()
                .anyMatch(x -> nameOfContact.equals(x.getText()));
                 }
}


