package com.automationpractice.Pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='radio']")
    WebElement selectTitle;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "firstname")
    WebElement addressFirstName;

    @FindBy(id = "lastname")
    WebElement addressLastName;

    @FindBy(id = "address1")
    WebElement addressLine1;

    @FindBy(id = "city")
    WebElement addressCity;

    @FindBy(id = "id_state")
    WebElement addressState; // dropdown

    @FindBy(id = "postcode")
    WebElement addressPostcode;     // only 5 digits

    @FindBy(id = "id_country")
    WebElement addressCountry;  // dropdown

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountText;


    public void enterPersonalInformation(String name, String lstName, String title, String passwrd){
        sendTextToElement(firstName, name);     // Input First Name
        sendTextToElement(lastName, lstName);     // Input Last Name
        clickOnElement(selectTitle, title);      // select title
        sendTextToElement(password, passwrd);     // Input password Name
       }

    public void enterAddressDetails(String fName, String lstName,String address, String city, String state, String postcode, String mobile){
        sendTextToElement(addressFirstName, fName);      // Address first name
        sendTextToElement(addressLastName, lstName);       // Address last name
        sendTextToElement(addressLine1, address);       // Address
        sendTextToElement(addressCity, city);       // Address City name
        selectByVisibleTextFromDropDown(addressState, state);  // Address State
        sendTextToElement(addressPostcode, postcode);   // Postalcode
        sendTextToElement(mobilePhone, mobile);     // mobile number
       }

    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
       }

    public void verifyMyAccountText(String text){
        verifyThatTextIsDisplayed(myAccountText, text);

    }

}
