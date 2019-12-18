package base;

import configurationManager.BaseConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static configurationManager.BaseConfiguration.getDriver;

public class BasePage extends Base{
    public WebDriver driver = BaseConfiguration.getDriver();

    public void waitUntilLoading(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 8000);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.ignoring(StaleElementReferenceException.class);
    }

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }
}
