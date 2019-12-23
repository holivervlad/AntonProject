package base;

import configurationManager.BaseConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Base{
    public WebDriver driver = BaseConfiguration.getDriver();
    private WebElement element;

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
