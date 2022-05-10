package com.automationpractice.Pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage extends Utility {

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement authenticationMessage;

    @FindBy(id = "email")
    WebElement emailAddressField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "email_create")
    WebElement createAccountEmail;

    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement emailRequiredError;

    @FindBy(xpath = "//li[contains(text(),'Password is required.')]")
    WebElement passwordRequiredError;

    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement invalidEmail;

    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement authenticationFailed;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signoutButton;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    @FindBy(xpath="//input[@id='email_create']")
    WebElement emailAddress;

    public void enterEmailAddressToCreateAccount(String email){
        sendTextToElement(emailAddress,email);
    }


    public void verifyAuthenticationMessage(String text) {
        verifyThatTextIsDisplayed(authenticationMessage, text);

    }

    public void inputEmailAddress(String text) {
        sendTextToElement(emailAddressField, text);

    }

    public void inputPassword(String text) {
        sendTextToElement(passwordField, text);

    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);

    }

    public void verifySignOutLinkIsVisible() {
        verifyThatElementIsDisplayed(signoutButton);

    }

    public void clickOnSignOutLink() {
        clickOnElement(signoutButton);

    }

    public void verifySignInLinkVisible() {
        verifyThatElementIsDisplayed(signInLink);

    }

    public void inputEmailToCreateAccount(String text) {
        sendTextToElement(createAccountEmail, text);

    }

    public void clickOnCreateAccountButton() {
        clickOnElement(createAccountButton);

    }

    public void inputCredentials(String username, String password) {
        sendTextToElement(emailAddressField, username);
        sendTextToElement(passwordField, password);

    }

    // This method will get error message
    public void verifyErrorMessage(String errorMessage) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMessage)) {
                break;
            }
        }
    }
}

