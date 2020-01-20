package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ContactPage extends BasePage {
    BasePage basePage;
    public static List<WebElement> sobjectList;

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

//    @FindBy(xpath = "//a[@title = 'Contacts']/span[2]")
    @FindBy(xpath = "//li//a[@title = 'Contacts']")
    private WebElement contactsTab;

    @FindBy(xpath = "//li//span[text() = 'All Contacts']")
    private WebElement allContactsListView;

    public ContactPage openContactListViewFromContact() {
        waitUntilElementIsShown(tabDropDown);
        tabDropDown.click();
        waitUntilElementIsShown(contactsTab);
        contactsTab.click();
        return this;
    }

    public ContactPage openAllContactsListView() {
        waitUntilElementIsShown(listViewDropDown);
        listViewDropDown.click();
        waitUntilElementIsShown(allContactsListView);
        allContactsListView.click();
        waitUntilElementIsShown(listViewDropDown);
        listViewDropDown.click();
        waitUntilElementIsShown(allContactsListView);
        allContactsListView.click();
        return this;
    }

    public boolean isSpecialContactsDisplay(String nameOfContact) {
        waitUntilElementIsShown(allContactsListView);

        sobjectList = allElementsOfCurrentListView.stream()
                .filter(s -> s.equals(nameOfContact))
                .collect(Collectors.toList());
        for (int iCounter = 0; iCounter <allElementsOfCurrentListView.size(); iCounter++) {
            if (sobjectList.get(iCounter).equals("test Contact 1 test")
                    || sobjectList.get(iCounter).equals("Test Contact 2 test")
                    || sobjectList.get(iCounter).equals("Mr. test FirstContact")
                    || sobjectList.get(iCounter).equals("test FourthContact")
                    || sobjectList.get(iCounter).equals("test LastContact")
                    || sobjectList.get(iCounter).equals("Ms. test SecondContact")
                    || sobjectList.get(iCounter).equals("test ThirdContact"))
                return true;
        }
        return false;



//        List<WebElement> linkElements = driver.findElements(By.xpath("//tbody//tr//th"));
//        linkElements.stream()
//                .filter(s -> s.equals(nameOfContact))
//                .collect(Collectors.toList())
//                .forEach(System.out::print);



//        Stream<WebElement> stream = allElementsOfCurrentListView.stream();
//        stream.filter(s -> s.equals(nameOfContact))
//                .forEach(System.out::print);
    }


//       //List<WebElement> list = Arrays.stream(allElementsOfCurrentListView)
//                .filter(s -> s.contains(nameOfContact))
//                .collect(Collectors.toList());

//        allElementsOfCurrentListView.stream()
//                .filter(s -> s.)
//        return ;



}



