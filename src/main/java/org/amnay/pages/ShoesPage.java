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

public class ShoesPage extends Base {
    Logger LOG = LogManager.getLogger(LoginPage.class.getName());

    public ShoesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "//*[@id=\"products-orderby\"]")
    WebElement dropdownSortBy;
    @FindBy(xpath = "//*[@class=\"price actual-price\"]")
    List<WebElement> itemsPrice;

    public void selectSortByPriceLowToHigh(String priceLowToHigh){
        selectDropdown(dropdownSortBy, priceLowToHigh);
    }
    public List<String> getItemsPrice(){
        List<String> prices = new ArrayList<>();
        for (WebElement itemPrice: itemsPrice){
            prices.add(itemPrice.getText().replace("$",""));
        }
        return prices;
    }
}
