package org.amnay;

import org.amnay.base.Base;
import org.amnay.pages.HomePage;
import org.amnay.pages.LoginPage;
import org.amnay.utility.ExcelReader;
import org.amnay.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogin extends Base {
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String email = excelReader.getDataForGivenHeaderAndKey("key", "email");
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnLogInLink();
        LOG.info("login link click success");
        //enter email
        loginPage.typeEmail(email);
        LOG.info("enter email success");

        //enter password
        loginPage.typePassword(password);
        LOG.info("enter password success");

        //click on login button
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");

        boolean logOutLinkIsDisplayed = homePage.logOutLinkIsDisplayed();
        Assert.assertTrue(logOutLinkIsDisplayed);
        LOG.info("Log out link is displayed success");
    }
    @Test
    public void loginAttemptWithoutEmail() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnLogInLink();
        LOG.info("login link click success");
        //enter username
        loginPage.typeEmail("");
        LOG.info("enter email success");

        //enter password
        loginPage.typePassword(password);
        LOG.info("enter password success");

        //click on login button
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");

        String textError = loginPage.getErrorEmailMessage();
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid email error message"), textError);
        LOG.info("error message validation success");
    }
    @Test
    public void loginAttemptWithoutPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String email = excelReader.getDataForGivenHeaderAndKey("key", "email");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnLogInLink();
        LOG.info("login link click success");
        //enter username
        loginPage.emailFieldIsDisplayed();
        LOG.info("email field is displayed");
        loginPage.typeEmail(email);
        LOG.info("enter email success");

        //enter password
        loginPage.passwordFieldIsDisplayed();
        LOG.info("password field is displayed");
        loginPage.typePassword("");
        LOG.info("enter password success");

        //click on login button
        loginPage.loginBtnIsDisplayed();
        LOG.info("login button is displayed");
        loginPage.clickOnLoginButton();
        LOG.info("login button click success");

        String textError = loginPage.getErrorMessage();
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "message error 1"), textError);
        LOG.info("error message validation success");


    }
}
