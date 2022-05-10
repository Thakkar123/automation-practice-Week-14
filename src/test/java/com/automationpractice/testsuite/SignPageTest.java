package com.automationpractice.testsuite;

import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.SignInPage;
import com.automationpractice.customlisteners.CustomListeners;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class SignPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        homePage = new HomePage();
        signInPage = new SignInPage();

    }

    @Test(groups = {"sanity","smoke","regression"})

    public void userShouldNavigateToSignInPageSuccessFully(){
            homePage.clickOnSignInLink();
            signInPage.verifyAuthenticationMessage("Authentication");
    }

    @Test(groups = {"smoke","regression"},dataProvider = "credentials",dataProviderClass = TestData.class)

    public void verifyTheErrorMessageWithInValidCredentials(String username, String password,String message){
        userShouldNavigateToSignInPageSuccessFully();
        signInPage.inputCredentials(username,password);
        signInPage.clickOnSignInButton();
        signInPage.verifyErrorMessage(message);
    }

    @Test(groups = {"regression"})

    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnSignInLink();
        signInPage.inputEmailAddress("RameshPatel123@gmail.com");
        signInPage.inputPassword("Temp123");
        signInPage.clickOnSignInButton();
        signInPage.verifySignOutLinkIsVisible();
    }
    @Test(groups = {"regression"})

    public void verifyThatUserShouldLogOutSuccessFully(){
        verifyThatUserShouldLogInSuccessFullyWithValidCredentials();
        signInPage.clickOnSignOutLink();
        signInPage.verifySignInLinkVisible();
    }



}
