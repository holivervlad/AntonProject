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

    public void waitUntilElementIsShown(WebElement element) {
//        new WebDriverWait(driver, 10)
//                .ignoring(StaleElementReferenceException.class);
        if (spinnerIsActive.isEnabled()) {
            new WebDriverWait(driver, 5);
            spinnerIsNotActive.isDisplayed();
            //.until(ExpectedConditions.invisibilityOf(spinnerIsNotActive));
            new WebDriverWait(driver, 5)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } else {
            spinnerIsNotActive.isEnabled();
            new WebDriverWait(driver, 5)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        }


        }
//        else {
//        spinnerIsActive.isDisplayed();}
//        new WebDriverWait(driver, 10)
//                .ignoring(StaleElementReferenceException.class)
//                .until(ExpectedConditions.visibilityOf(element));

//
//        wait.until(ExpectedConditions.visibilityOf(element));
//        wait.ignoring(StaleElementReferenceException.class);
//        WebDriverWait wait4 = new WebDriverWait(driver, 10000);
//        wait4.ignoring(StaleElementReferenceException.class);
//
//        Wait<WebDriver> wait2 = new WebDriverWait(driver, 20, 5000);
//        wait2.until(ExpectedConditions.visibilityOf(element));
//
//        driver.manage().timeouts().setScriptTimeout(4000, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(6000, TimeUnit.SECONDS);
//       Wait<WebDriver> wait3 = new FluentWait<WebDriver>(driver).withMessage("Element was not found").withTimeout(10000, TimeUnit.SECONDS).pollingEvery(10000, TimeUnit.SECONDS);
//        wait3.until(ExpectedConditions.visibilityOf(element));


    public void waitUntilPageLoading(){
        new WebDriverWait(driver, 10)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected BasePage() {
        PageFactory.initElements(driver, this);
        waitUntilPageLoading();

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
