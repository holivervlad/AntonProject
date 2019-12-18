package pages;

import base.BasePage;
import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LogInPage extends BasePage {

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement logInButton;

    public HomePage logInPlayGround(String emailData, String passwordData) {
        emailField.sendKeys(emailData);
        passwordField.sendKeys(passwordData);
        logInButton.click();
        return new HomePage();
    }
}
