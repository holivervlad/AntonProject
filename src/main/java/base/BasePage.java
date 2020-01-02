package base;

import configurationManager.BaseConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void waitUntilLoading(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.ignoring(StaleElementReferenceException.class);

        Wait<WebDriver> wait2 = new WebDriverWait(driver, 20, 5000);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void scrollToDownOfThePage(WebElement elementFirst, WebElement elementSecond) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elementFirst);
        actions.perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementSecond);
        //
        //
    }
}
