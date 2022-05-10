package com.automationpractice.Pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    public ProductPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(id = "group_1")
    WebElement selectSize;

    @FindBy(className = "attribute_list")
    WebElement color;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeButton;

    public void addProductAttribute(String qty, String size, String colour) {
        sendKeysToElement(quantity, Keys.BACK_SPACE + qty);
        selectByVisibleTextFromDropDown(selectSize, size);
        clickOnElement(color, colour);
     }

    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);

    }

    public void verifyProductAddedToCartMessage(String text){
        verifyThatTextIsDisplayed(popUpDisplay, text);

    }

    public void clickOnCloseButton(){
        clickOnElement(closeButton);

    }

}
