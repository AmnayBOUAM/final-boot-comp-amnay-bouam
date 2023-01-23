package org.amnay.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.amnay.base.Base;

public class LoginPage extends Base {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"Email\"]")
    WebElement emailField;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement passwordField;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id='Email-error']")
    WebElement emailError;
    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    //reusable steps
    public boolean emailFieldIsDisplayed(){
        LOG.info("checking email field is displayed ...");
        return isDisplayed(emailField);
    }
    public void typeEmail(String email){
        type(emailField, email);
    }
    public boolean passwordFieldIsDisplayed(){
        LOG.info("checking password field is displayed ...");
        return isDisplayed(passwordField);
    }
    public void typePassword(String password){
        type(passwordField, password);
    }
    public boolean loginBtnIsDisplayed(){
        LOG.info("checking login button is displayed ...");
        return isDisplayed(loginBtn);
    }
    public void clickOnLoginButton(){
        clickOn(loginBtn);
    }

    public String getErrorMessage(){
        return getWebElementText(errorMessage);
    }

    public String getErrorEmailMessage(){
        return getWebElementText(emailError);
    }
}





