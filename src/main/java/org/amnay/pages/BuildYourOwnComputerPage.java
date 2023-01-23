package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BuildYourOwnComputerPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public BuildYourOwnComputerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement dropdownRAM;
    @FindBy(xpath = "//*[@id='add-to-cart-button-1']")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@class='content']")
    WebElement barNotificationSuccess;

    @FindBy(xpath = "//*[@class='bar-notification error']")
    WebElement barNotificationErrorRAM;

    @FindBy(xpath = "//*[@name='product_attribute_3']")
    List<WebElement> radioButtonsHDD;

    public void selectRadioButtonsHDD(String attribute, String value){
        selectRadioButton(radioButtonsHDD, attribute, value);
    }
    public void selectRAM (String RAM){
        selectDropdown(dropdownRAM, RAM);
    }



    public boolean barNotificationSuccessIsDisplayed(){
        LOG.info("checking bar notification success is displayed ...");
        return isDisplayed(barNotificationSuccess);
    }
    public boolean barNotificationErrorRAMIsDisplayed(){
        LOG.info("checking bar notification error is displayed ...");
        return isDisplayed(barNotificationErrorRAM);
    }

    public void clickOnAddToCartButton(){
        clickOn(addToCartButton);
    }


    public boolean addToCartButtonIsDisplayed(){
        LOG.info("checking add to cart button is displayed ...");
        return isDisplayed(addToCartButton);
    }
}