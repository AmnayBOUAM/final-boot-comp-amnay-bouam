package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public DesktopsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a")
    WebElement buildYourOwnComputer;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]")
    WebElement addToCartVANQUISH3;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[3]")
    WebElement addToWishListVANQUISH3;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    WebElement barNotificationSuccess;

    public boolean buildYourOwnComputerIsDisplayed(){
        LOG.info("checking build your own computer link is displayed ...");
        return isDisplayed(buildYourOwnComputer);
    }
    public void clickOnBuildYourOwnComputer(){
        clickOn(buildYourOwnComputer);
        LOG.info("click on build your own computer success");
    }
    public void clickOnAddToCartVANQUISH3(){
        clickOn(addToCartVANQUISH3);
        LOG.info("click on add to cart success");
    }
    public void clickOnAddToWishListVANQUISH3(){
        clickOn(addToWishListVANQUISH3);
        LOG.info("click on add to cart success");
    }
    public boolean barNotificationSuccessIsDisplayed(){
        LOG.info("checking bar notification success is displayed ...");
        return isDisplayed(barNotificationSuccess);
    }

    public void waitForBarNotificationSuccessBeAvailable(WebDriver driver){
        waitForElementToBeAvailable(driver,barNotificationSuccess);
    }
}
