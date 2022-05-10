package com.automationpractice.Pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Women']")
        WebElement women;

    @FindBy(xpath = "(//a[@title='Dresses'][normalize-space()='Dresses'])[2]")
    WebElement dresses;

    @FindBy(xpath = "(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]")
    WebElement tshirts;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logoLocator;

    public void clickOnWomenTab(){
        clickOnElement(women);

    }
    public void clickOnDressesTab(){
        clickOnElement(dresses);

    }
    public void clickOnTshirtsTab(){
        clickOnElement(tshirts);

    }

    public void clickOnSignInLink(){
        clickOnElement(signInLink);
    }

    public void verifyLogoisVisible() {
        verifyThatElementIsDisplayed(logoLocator);
    }

}
