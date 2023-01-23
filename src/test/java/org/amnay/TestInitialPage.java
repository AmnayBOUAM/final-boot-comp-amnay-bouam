package org.amnay;

import org.amnay.base.Base;
import org.amnay.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.amnay.utility.ExcelReader;
import org.amnay.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestInitialPage extends Base {
    Logger LOG = LogManager.getLogger(TestInitialPage.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    @Test
    public void validateLandingPage(){
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
    }

    @Test
    public void validateHomePageElements(){
        HomePage homePage = new HomePage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //login link
        boolean logInLinkIsDisplayed = homePage.logInLinkIsDisplayed();
        Assert.assertTrue(logInLinkIsDisplayed);
        LOG.info("login link field is displayed");

        //register link
        boolean registerLinkIsDisplayed = homePage.registerLinkIsDisplayed();
        Assert.assertTrue(registerLinkIsDisplayed);
        LOG.info("register link is displayed");

        //wishlist link
        boolean wishlistLinkIsDisplayed = homePage.wishlistLinkIsDisplayed();
        Assert.assertTrue(wishlistLinkIsDisplayed);
        LOG.info("wishlist link is displayed");
    }


}
