package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends Base {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());
    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='FirstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//*[@id='LastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dropdownDateOfBirthDay;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement dropdownDateOfBirthMonth;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement dropdownDateOfBirthYear;
    @FindBy(xpath = "//*[@id='Email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@name='Password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@name='ConfirmPassword']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//*[@id='register-button']")
    WebElement registerBtn;

    @FindBy(xpath = "//*[@id='gender-male']")
    WebElement genderMale;

    @FindBy(xpath = "//*[@id=\"Email-error\"]")
    WebElement emailError;

    @FindBy(xpath = "//*[@id=\"Email-error\"]")
    WebElement emailIsRequired;

    @FindBy(xpath = "//*[@id=\"Password-error\"]")
    WebElement passwordError;

    @FindBy(xpath = "//*[@id=\"ConfirmPassword-error\"]")
    WebElement confirmPasswordError;




    public void clickOnGenderMale(){

        clickOn(genderMale);
    }
    public void typeFirstName(String firstName){
        type(firstNameField, firstName);
    }
    public void typeLastName(String lastName){
        type(lastNameField, lastName);
    }

    public void selectBirthDay(String birthDay){
        selectDropdown(dropdownDateOfBirthDay, birthDay);
    }
    public void selectBirthMonth(String birthMonth){
        selectDropdown(dropdownDateOfBirthMonth, birthMonth);
    }
    public void selectBirthYear(String birthYear){
        selectDropdown(dropdownDateOfBirthYear, birthYear);
    }
    public void typeEmail(String email){

        type(emailField, email);
    }
    public void typePassword(String password){
        type(passwordField, password);
    }
    public void typeConfirmPassword(String confirmPassword){
        type(confirmPasswordField, confirmPassword);
    }
    public void clickOnRegisterButton(){

        clickOn(registerBtn);
    }

    public boolean emailErrorIsDisplayed(){
        LOG.info("checking email error is displayed ...");
        return isDisplayed(emailError);
    }
    public String getEmailErrorMessage(){
        return getWebElementText(emailError);
    }

    public boolean emailIsRequiredIsDisplayed(){
        LOG.info("checking email is required is displayed ...");
        return isDisplayed(emailIsRequired);
    }

    public String getEmailIsRequiredMessage(){
        return getWebElementText(emailIsRequired);
    }

    public boolean passwordIsRequiredIsDisplayed(){
        LOG.info("checking password is required is displayed ...");
        return isDisplayed(passwordError);
    }

    public String getPasswordIsRequiredMessage(){
        return getWebElementText(passwordError);
    }

    public boolean confirmPasswordErrorIsDisplayed(){
        LOG.info("checking confirm password error is displayed ...");
        return isDisplayed(confirmPasswordError);
    }

    public String getConfirmPasswordErrorMessage(){
        return getWebElementText(confirmPasswordError);
    }

}
