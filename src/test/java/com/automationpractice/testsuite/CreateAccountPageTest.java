package com.automationpractice.testsuite;

import com.automationpractice.Pages.CreateAccountPage;
import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.SignInPage;
import com.automationpractice.customlisteners.CustomListeners;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {

        HomePage homePage;
        SignInPage signInPage;
        CreateAccountPage createAccountPage;

        @BeforeMethod(alwaysRun = true)
        public void initialize(){
            homePage = new HomePage();
            signInPage = new SignInPage();
            createAccountPage = new CreateAccountPage();
        }
        @Test(groups = {"sanity","smoke","regression"})

        public void verifyThatUserShouldCreateAccountSuccessfully(){
            homePage.clickOnSignInLink();
            signInPage.enterEmailAddressToCreateAccount("RameshPatel200@gmail.com");
            signInPage.clickOnCreateAccountButton();
            createAccountPage.enterPersonalInformation("Ramesh","Patel","Mr","Temp123");
            createAccountPage.enterAddressDetails("Ramesh","Patel","Buckingham Palace","London","California","52456","012596857");
            createAccountPage.clickOnRegisterButton();
            createAccountPage.verifyMyAccountText("My account");
        }
}
