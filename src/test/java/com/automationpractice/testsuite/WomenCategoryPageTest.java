package com.automationpractice.testsuite;

import com.automationpractice.Pages.*;
import com.automationpractice.customlisteners.CustomListeners;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
    }
    @Test(groups = {"sanity", "smoke", "regression"})

    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully()
    {
        homePage.clickOnWomenTab();
        womenCategoryPage.verifyWomenText("Women");
    }
    @Test(groups = {"smoke", "regression"},dataProvider = "product",dataProviderClass = TestData.class)

    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour) {
        homePage.clickOnWomenTab();
        womenCategoryPage.addProductToCart(product);
        productPage.addProductAttribute(qty, size, colour);
        productPage.clickOnAddToCartButton();
        productPage.verifyProductAddedToCartMessage("Product successfully added to your shopping cart");
        productPage.clickOnCloseButton();
    }
}
