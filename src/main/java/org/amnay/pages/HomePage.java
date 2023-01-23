package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement logInLink;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement logOutLink;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement registerLink;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]")
    WebElement wishlistLink;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    WebElement shoppingCartLink;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computersLink;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a")
    WebElement desktops;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    WebElement notebooks;

    @FindBy(xpath = "//*[@id=\"flyout-cart\"]/div/div[4]/button")
    WebElement goToCartBtn;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
    WebElement closeBarNotification;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li/*[@href='/apparel']")
    WebElement apparelLink;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a")
    WebElement shoesLink;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[2]")
    WebElement quantityItemsInCart;

    //reusable steps
    public boolean logInLinkIsDisplayed(){
        LOG.info("checking login link is displayed ...");
        return isDisplayed(logInLink);
    }

    public boolean registerLinkIsDisplayed(){
        LOG.info("checking Register link is displayed ...");
        return isDisplayed(registerLink);
    }
    public boolean shoppingCartLinkIsDisplayed(){
        LOG.info("checking shopping cart link is displayed ...");
        return isDisplayed(shoppingCartLink);
    }

    public boolean wishlistLinkIsDisplayed(){
        LOG.info("checking wish list link is displayed ...");
        return isDisplayed(wishlistLink);
    }
    public boolean computersLinkIsDisplayed(){
        LOG.info("checking computers link is displayed ...");
        return isDisplayed(computersLink);
    }
    public void clickOnLogOutLink(){clickOn(logOutLink);}

    public void clickOnWishlistLink(){
        clickOn(wishlistLink);
    }

    public void waitForWishlistLinkBeAvailable(WebDriver driver){

        waitForElementToBeAvailable(driver,wishlistLink);
    }


    public boolean logOutLinkIsDisplayed(){
        boolean flag = isDisplayed(logOutLink);
        LOG.info("log out link is displayed");
        return flag;
    }

    public void clickOnLogInLink(){
        clickOn(logInLink);
        LOG.info("click on login link success");
    }
    public void clickOnRegisterLink(){
        clickOn(registerLink);
        LOG.info("click on register link success");
    }
    public void clickOnShoppingCartLink(){
        clickOn(shoppingCartLink);
        LOG.info("click on shopping cart link success");
    }
    public void clickOnComputersLink(){
        clickOn(computersLink);
        LOG.info("click on register link success");
    }
    public void clickOnCloseBarNotification(){
        clickOn(closeBarNotification);
        LOG.info("click on close bar notification success");
    }
    public void hoverOverCart(WebDriver driver){
        hoverOver(driver, shoppingCartLink);
        LOG.info("hover over cart success");
    }
    public void clickOnGoToCartBtn(){
        clickOn(goToCartBtn);
        LOG.info("click on go to cart button success");
    }

    public void hoverOverComputers(WebDriver driver){
        hoverOver(driver, computersLink);
        LOG.info("hover over computers success");
    }
    public void clickOnDesktops(){
        clickOn(desktops);
        LOG.info("click on desktops success");
    }

    public void waitForDesktopsToBeClickable(WebDriver driver){

        waitForElementToBeClickable(driver, desktops);
    }


    public void clickOnNotebooks(){
        clickOn(notebooks);
        LOG.info("click on notebooks success");
    }

    public void waitForNotebooksToBeClickable(WebDriver driver){

        waitForElementToBeClickable(driver, notebooks);
    }

    public void hoverOverApparelLink(WebDriver driver){
        hoverOver(driver, apparelLink);
        LOG.info("hover over apparel success");
    }
    public void clickOnShoesLink(){
        clickOn(shoesLink);
        LOG.info("click on shoes success");
    }

    public String getItemsQuantityInCart(){
        String quantity = quantityItemsInCart.getText().replace("(","").replace(")","");
        return quantity ;
    }
}
