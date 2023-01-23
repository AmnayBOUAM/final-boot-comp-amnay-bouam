package org.amnay.pages;

import org.amnay.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareProductsPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public CompareProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "//*[@class='remove-product']/td[2]/button")
    WebElement removeBtn;

    @FindBy(xpath = "//*[@class='no-data']")
    WebElement compareListEmpty;

    @FindBy(xpath = "//*[@class='clear-list']")
    WebElement clearListBtn;

    @FindBy(xpath = "//*[@class='page-title']")
    WebElement pageTitle;

    public void clickOnRemoveBtn(){
        clickOn(removeBtn);
    }
    public boolean removeBtnIsDisplayed(){
        LOG.info("checking remove button is displayed ...");
        return isDisplayed(removeBtn);
    }
    public boolean compareListEmptyIsDisplayed(){
        LOG.info("checking compare list empty is displayed ...");
        return isDisplayed(compareListEmpty);
    }

    public void clickOnClearListBtn(){
        clickOn(clearListBtn);
    }
    public boolean clearListBtnIsDisplayed(){
        LOG.info("checking clear list button is displayed ...");
        return isDisplayed(clearListBtn);
    }
}
