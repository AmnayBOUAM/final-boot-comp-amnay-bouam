package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishLisPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public WishLisPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td[8]/button")
    WebElement removeBtn;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td[1]/input")
    WebElement addToCartCheckbox;

    @FindBy(xpath = "//*[@class='no-data']")
    WebElement wishlistEmpty;

    @FindBy(xpath = "//*[@class='quantity']/input")

    WebElement itemQuantity;

    @FindBy(xpath = "//*[@id=\"updatecart\"]")
    WebElement updateWishlistBtn;

    @FindBy(xpath = "//*[@name='addtocartbutton']")
    WebElement addToCartBtn;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[5]/span")
    WebElement unitPrice;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[7]/span")
    WebElement productSubtotal;


    public void clickOnRemoveBtn(){
        clickOn(removeBtn);
    }
    public boolean removeBtnIsDisplayed(){
        LOG.info("checking remove button is displayed ...");
        return isDisplayed(removeBtn);
    }
    public boolean wishlistEmptyIsDisplayed(){
        LOG.info("checking wishlist empty is displayed ...");
        return isDisplayed(wishlistEmpty);
    }
    public String updateQuantity(String quantity){
        itemQuantity.sendKeys(Keys.BACK_SPACE);
        type(itemQuantity, quantity);
        return quantity;
    }
    public void clickOnUpdateWishlistBtn(){
        clickOn(updateWishlistBtn);
    }
    public boolean updateWishlistBtnIsDisplayed(){
        LOG.info("checking update wishlist button is displayed ...");
        return isDisplayed(updateWishlistBtn);
    }

    public void clickOnAddToCartCheckbox(){
        clickOn(addToCartCheckbox);
    }
    public boolean addToCartCheckboxIsDisplayed(){
        LOG.info("checking add to cart checkbox is displayed ...");
        return isDisplayed(addToCartCheckbox);
    }

    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
    }
    public boolean addToCartBtnIsDisplayed(){
        LOG.info("checking add to cart button is displayed ...");
        return isDisplayed(addToCartBtn);
    }

    public String getItemsQuantity(){
        String quantity = itemQuantity.getAttribute("value");
        return quantity;
    }
    public String getUnitPrice(){
        String unitPriceString = unitPrice.getText().replace("$","").replace(",","");
        return unitPriceString;
    }
    public String getProductSubtotal(){
        String productSubtotalString = productSubtotal.getText().replace("$","").replace(",","");
        return productSubtotalString;
    }

    public void checkProductSubtotal(String quantity){
        Double unitPrice = Double.parseDouble(getUnitPrice());
        Double productSubTotal = Double.parseDouble(getProductSubtotal());
        int itemQuantity = Integer.parseInt(updateQuantity(quantity));
        if (productSubTotal == (unitPrice*itemQuantity)){
            LOG.info("checking product subtotal success : $"+productSubTotal+" = $"+unitPrice+" * "+itemQuantity);
        }
    }
}
