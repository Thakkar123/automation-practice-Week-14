package com.automationpractice.testbase;

import com.automationpractice.propertyreader.PropertyReader;
import com.automationpractice.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");
    @BeforeMethod(alwaysRun = true)
    public void setUP()
    {
        selectBrowser(browser);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        closeBrowser();
    }

}
