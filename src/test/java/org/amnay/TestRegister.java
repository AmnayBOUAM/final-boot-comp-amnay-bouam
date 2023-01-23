package org.amnay;

import org.amnay.base.Base;
import org.amnay.pages.HomePage;
import org.amnay.pages.RegisterPage;
import org.amnay.utility.ExcelReader;
import org.amnay.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestRegister extends Base {
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");


    @Test
    public void registerWithValidCredentials() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String email = excelReader.getDataForGivenHeaderAndKey("key", "email");
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnRegisterLink();
        LOG.info("register link click success");

        registerPage.clickOnGenderMale();
        LOG.info("click on gender male success");

        registerPage.typeFirstName("Edden");
        LOG.info("enter first name success");

        registerPage.typeLastName("Hasard");
        LOG.info("enter last name success");

        registerPage.selectBirthDay("3");
        LOG.info("select birth day success");

        registerPage.selectBirthMonth("June");
        LOG.info("select birth month success");

        registerPage.selectBirthYear("1999");
        LOG.info("select birth year success");
        //enter email
        registerPage.typeEmail(email);
        LOG.info("enter email success");

        //enter password
        registerPage.typePassword(password);
        LOG.info("enter password success");

        registerPage.typeConfirmPassword(password);
        LOG.info("enter confirm password success");
        //click on login button
        registerPage.clickOnRegisterButton();
        LOG.info("register button click success");

    }

    @Test
    public void registerAttemptWithEmailError() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnRegisterLink();
        LOG.info("register link click success");

        registerPage.clickOnGenderMale();
        LOG.info("click on gender male success");

        registerPage.typeFirstName("Edden");
        LOG.info("enter first name success");

        registerPage.typeLastName("Hasard");
        LOG.info("enter last name success");

        registerPage.selectBirthDay("3");
        LOG.info("select birth day success");

        registerPage.selectBirthMonth("June");
        LOG.info("select birth month success");

        registerPage.selectBirthYear("1999");
        LOG.info("select birth year success");
        //enter email
        registerPage.typeEmail("a");
        LOG.info("enter email success");

        //enter password
        registerPage.typePassword(password);
        LOG.info("enter password success");

        registerPage.typeConfirmPassword(password);
        LOG.info("enter confirm password success");
        //click on login button
        registerPage.clickOnRegisterButton();
        LOG.info("register button click success");

        registerPage.emailErrorIsDisplayed();
        LOG.info("email error is displayed");
        LOG.info(registerPage.getEmailErrorMessage());

    }

    @Test
    public void registerAttemptWithoutEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnRegisterLink();
        LOG.info("register link click success");

        registerPage.clickOnGenderMale();
        LOG.info("click on gender male success");

        registerPage.typeFirstName("Edden");
        LOG.info("enter first name success");

        registerPage.typeLastName("Hasard");
        LOG.info("enter last name success");

        registerPage.selectBirthDay("3");
        LOG.info("select birth day success");

        registerPage.selectBirthMonth("June");
        LOG.info("select birth month success");

        registerPage.selectBirthYear("1999");
        LOG.info("select birth year success");
        //enter email
        registerPage.typeEmail("");
        LOG.info("enter email success");

        //enter password
        registerPage.typePassword(password);
        LOG.info("enter password success");

        registerPage.typeConfirmPassword(password);
        LOG.info("enter confirm password success");
        //click on login button
        registerPage.clickOnRegisterButton();
        LOG.info("register button click success");

        registerPage.emailIsRequiredIsDisplayed();
        LOG.info("email is required is displayed");
        LOG.info(registerPage.getEmailIsRequiredMessage());

    }

    @Test
    public void registerAttemptWithoutPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String email = excelReader.getDataForGivenHeaderAndKey("key", "email");
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnRegisterLink();
        LOG.info("register link click success");

        registerPage.clickOnGenderMale();
        LOG.info("click on gender male success");

        registerPage.typeFirstName("Edden");
        LOG.info("enter first name success");

        registerPage.typeLastName("Hasard");
        LOG.info("enter last name success");

        registerPage.selectBirthDay("3");
        LOG.info("select birth day success");

        registerPage.selectBirthMonth("June");
        LOG.info("select birth month success");

        registerPage.selectBirthYear("1999");
        LOG.info("select birth year success");
        //enter email
        registerPage.typeEmail(email);
        LOG.info("enter email success");

        //enter password
        registerPage.typePassword("");
        LOG.info("enter password success");

        registerPage.typeConfirmPassword("");
        LOG.info("enter confirm password success");
        //click on login button
        registerPage.clickOnRegisterButton();
        LOG.info("register button click success");

        registerPage.passwordIsRequiredIsDisplayed();
        LOG.info("password is required is displayed");
        LOG.info(registerPage.getPasswordIsRequiredMessage());

        registerPage.confirmPasswordErrorIsDisplayed();
        LOG.info("confirm password is required is displayed");
        LOG.info(registerPage.getConfirmPasswordErrorMessage());

    }

    @Test
    public void registerAttemptWithDifferentPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String email = excelReader.getDataForGivenHeaderAndKey("key", "email");
        String password = excelReader.getDataForGivenHeaderAndKey("key", "password");

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.clickOnRegisterLink();
        LOG.info("register link click success");

        registerPage.clickOnGenderMale();
        LOG.info("click on gender male success");

        registerPage.typeFirstName("Edden");
        LOG.info("enter first name success");

        registerPage.typeLastName("Hasard");
        LOG.info("enter last name success");

        registerPage.selectBirthDay("3");
        LOG.info("select birth day success");

        registerPage.selectBirthMonth("June");
        LOG.info("select birth month success");

        registerPage.selectBirthYear("1999");
        LOG.info("select birth year success");
        //enter email
        registerPage.typeEmail(email);
        LOG.info("enter email success");

        //enter password
        registerPage.typePassword(password);
        LOG.info("enter password success");

        registerPage.typeConfirmPassword(password+"2");
        LOG.info("enter confirm password success");
        //click on login button
        registerPage.clickOnRegisterButton();
        LOG.info("register button click success");

        registerPage.confirmPasswordErrorIsDisplayed();
        LOG.info("confirm password is required is displayed");
        LOG.info(registerPage.getConfirmPasswordErrorMessage());
        ;

    }
}
