package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[7]")
    WebElement removeBtn;

    @FindBy(xpath = "//*[@class='no-data']")
    WebElement shoppingCartEmpty;

    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[5]/input")

    WebElement itemQuantity;

    @FindBy(xpath = "//*[@id='updatecart']")
    WebElement updateCartBtn;

    public void clickOnRemoveBtn(){
        clickOn(removeBtn);
    }
    public boolean removeBtnIsDisplayed(){
        LOG.info("checking remove button is displayed ...");
        return isDisplayed(removeBtn);
    }
    public boolean shoppingCartEmptyIsDisplayed(){
        LOG.info("checking shopping cart empty is displayed ...");
        return isDisplayed(shoppingCartEmpty);
    }
    public void updateQuantity(String quantity){
        itemQuantity.sendKeys(Keys.BACK_SPACE);
        type(itemQuantity, quantity);
    }
    public void clickOnUpdateCartBtn(){
        clickOn(updateCartBtn);
    }
    public boolean updateCartBtnIsDisplayed(){
        LOG.info("checking update cart button is displayed ...");
        return isDisplayed(updateCartBtn);
    }

}
