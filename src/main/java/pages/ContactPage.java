package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {

    @FindBy(xpath = "//div[text() = 'New']")
    private WebElement newButton;

    @FindBy(xpath = "//div[text() = 'Import']")
    private WebElement importButton;

    @FindBy(xpath = "//div[text() = 'Send List Email']")
    private WebElement sendListEmailButton;

    @FindBy(xpath = "//lightning-input[@class='slds-form-element']")
    private WebElement localSearch;

    @FindBy(xpath = "//div[@class = 'triggerLinkTextAndIconWrapper slds-p-right--x-large']//a")
    private WebElement listViewButton; //// for this use contains,

    @FindBy(xpath = "//button[@title='List View Controls']")
    private WebElement listViewControlsButton;

    @FindBy(xpath = "//button[@title='Display as Table']")
    private WebElement displayAsTableButton;

    @FindBy(xpath = "//button[@name = 'refreshButton']")
    private WebElement refreshButton;

    @FindBy(xpath = "//button[@name = 'inlineEditButton']")
    private WebElement inlineEditButton;
}
