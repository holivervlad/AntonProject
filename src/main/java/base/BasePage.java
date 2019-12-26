package base;

import configurationManager.BaseConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        WebDriverWait wait = new WebDriverWait(driver, 8000);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.ignoring(StaleElementReferenceException.class);
    }

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void scrollToDownOfThePage(WebElement elementFirst, WebElement elementSecond) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elementFirst);
        actions.perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementSecond);
    }
}
