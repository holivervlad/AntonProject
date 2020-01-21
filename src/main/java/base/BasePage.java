package base;

import configurationManager.BaseConfiguration;
import net.bytebuddy.implementation.bytecode.Addition;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class BasePage extends Base{
    public WebDriver driver = BaseConfiguration.getDriver();
    private WebElement element;

    @FindBy(xpath = "//a[@role = 'button'][@title = 'Select List View']")
    public WebElement listViewDropDown;

    @FindBy(xpath = "//button[@title = 'Show Navigation Menu']")
    public WebElement tabDropDown;

    @FindBy(xpath = "//tbody//tr//th")
    public List<WebElement> allElementsOfCurrentListView;

    @FindBy(xpath = "//div[@class='slds-spinner_container slds-grid slds-hide']")
    public WebElement spinnerIsNotActive;

    @FindBy(xpath = "//div[@class='slds-spinner_container slds-grid']")
    public WebElement spinnerIsActive;

    protected BasePage() {
        PageFactory.initElements(driver, this);
        waitUntilPageLoading();

    }

    public void waitUntilSpinnerIsShown() {
        new WebDriverWait(driver, 5)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(spinnerIsActive));
    }

    public void waitUntilSpinnerIsDisappeared() {
        new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.invisibilityOf(spinnerIsActive));
    }

    public void waitUntilElementIsShown(WebElement element) {
        try {

            spinnerIsActive.isDisplayed();
            waitUntilSpinnerIsDisappeared();
            new WebDriverWait(driver, 10)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            new WebDriverWait(driver, 10)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        }
    }

    public void waitSpinners() {
        waitUntilSpinnerIsShown();
        waitUntilSpinnerIsDisappeared();
    }
////////////////////////////////////////////////
    public void catchSpinner() {
        try {
            new WebDriverWait(driver, 10);
        } catch (NoSuchElementException e) {
            new WebDriverWait(driver, 10);

        }
    }

    public void waitElementAfterSpinnerIsDisappeared(WebElement element) {
        catchSpinner();
        waitUntilElementIsShown(element);

    }






    public void waitUntilPageLoading(){
        new WebDriverWait(driver, 20)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }



//    protected BasePage() {
//        PageFactory.initElements(driver, this);
//
//    }

    public void scrollToDownOfThePage(WebElement elementFirst, WebElement elementSecond) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elementFirst);
        actions.perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementSecond);
        //
        //
    }
}
