package com.automationpractice.Pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage extends Utility {

    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenText;

    @FindBy(xpath = "//div[@class='block_content']//a[normalize-space()='Tops']")
    WebElement topsLink;

    @FindBy(xpath = "//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']")
    WebElement dressesLink;

    @FindBy(id="selectProductSort")
    WebElement sortByDropDown;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement productsList;

    public void verifyWomenText(String text) {
        verifyThatTextIsDisplayed(womenText, text);

    }

    public void addProductToCart(String product) {
       clickOnElement(productsList, product);

    }

}
