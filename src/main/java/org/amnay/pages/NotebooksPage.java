package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotebooksPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public NotebooksPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[2]")
    WebElement addToCompareListMacBook;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[2]")
    WebElement addToCompareListAsus;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[2]")
    WebElement addToCompareListHP;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    WebElement barNotificationSuccess;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
    WebElement productComparisonLink;


    public void clickOnAddToCompareListMacBook(){
        clickOn(addToCompareListMacBook);
        LOG.info("click to add MacBook to compare list success");
    }
    public void clickOnAddToCompareListAsus(){
        clickOn(addToCompareListAsus);
        LOG.info("click to add Asus to compare list success");
    }
    public void clickOnAddToCompareListHP(){
        clickOn(addToCompareListHP);
        LOG.info("click to add HP to compare list success");
    }

    public void clickOnProductComparisonLink(){
        clickOn(productComparisonLink);
        LOG.info("click on product comparison link success");
    }
    public void waitForProductComparisonLinkToBeClickable(WebDriver driver){
        waitForElementToBeClickable(driver , productComparisonLink);
    }
    public boolean barNotificationSuccessIsDisplayed(){
        LOG.info("checking bar notification success is displayed ...");
        return isDisplayed(barNotificationSuccess);
    }

    public void waitForBarNotificationSuccessBeAvailable(WebDriver driver){
        waitForElementToBeAvailable(driver,barNotificationSuccess);
    }
}
