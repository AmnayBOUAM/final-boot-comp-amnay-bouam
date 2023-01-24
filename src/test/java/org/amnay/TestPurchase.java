package org.amnay;

import org.amnay.base.Base;
import org.amnay.pages.*;
import org.amnay.utility.ExcelReader;
import org.amnay.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestPurchase extends Base {
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");


    @Test
    public void buildYourOwnComputerWithValidSteps() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.buildYourOwnComputerIsDisplayed();
        LOG.info("build your own computer link is displayed");
        desktopsPage.clickOnBuildYourOwnComputer();
        buildYourOwnComputerPage.selectRAM("2 GB");
        buildYourOwnComputerPage.selectRadioButtonsHDD("value", "6");
        buildYourOwnComputerPage.addToCartButtonIsDisplayed();
        buildYourOwnComputerPage.clickOnAddToCartButton();
        LOG.info("add to cart button click success");
        buildYourOwnComputerPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");

    }
    @Test
    public void buildYourOwnComputerWithoutSelectingRAM() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.buildYourOwnComputerIsDisplayed();
        LOG.info("build your own computer link is displayed");
        desktopsPage.clickOnBuildYourOwnComputer();
        buildYourOwnComputerPage.selectRadioButtonsHDD("value", "6");
        buildYourOwnComputerPage.addToCartButtonIsDisplayed();
        buildYourOwnComputerPage.clickOnAddToCartButton();
        LOG.info("add to cart button click success");
        buildYourOwnComputerPage.barNotificationErrorRAMIsDisplayed();
        LOG.info("bar notification error RAM is displayed");
    }
    @Test
    public void addItemToCart() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToCartVANQUISH3();
        LOG.info("add to cart button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");

    }
    @Test
    public void updateQuantityInCart() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        CartPage cartPage = new CartPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");
        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToCartVANQUISH3();
        LOG.info("add to cart button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        homePage.shoppingCartLinkIsDisplayed();
        LOG.info("shopping cart link is displayed");
        homePage.clickOnCloseBarNotification();
        homePage.hoverOverCart(driver);
        homePage.clickOnGoToCartBtn();
        cartPage.updateQuantity("2");
        cartPage.updateCartBtnIsDisplayed();
        cartPage.clickOnUpdateCartBtn();
        LOG.info("update quantity in cart success");

    }
   @Test
    public void deleteItemInCart() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        CartPage cartPage = new CartPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");
        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToCartVANQUISH3();
        LOG.info("add to cart button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        homePage.shoppingCartLinkIsDisplayed();
        LOG.info("shopping cart link is displayed");
        homePage.clickOnCloseBarNotification();
        homePage.hoverOverCart(driver);
        waitFor(1);
        homePage.clickOnGoToCartBtn();
        cartPage.removeBtnIsDisplayed();
        cartPage.clickOnRemoveBtn();
        cartPage.shoppingCartEmptyIsDisplayed();
        LOG.info("delete items in cart success");

    }

    @Test
    public void filterFromLowToHigh()  {
        HomePage homePage = new HomePage(driver);
        ShoesPage shoesPage = new ShoesPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");
        homePage.hoverOverApparelLink(driver);
        homePage.clickOnShoesLink();
        shoesPage.selectSortByPriceLowToHigh("Price: Low to High");
        waitFor(1);
        LOG.info("list of prices: "+shoesPage.getItemsPrice());
        double[] finalPrices = Utility.listToArrayOfDoubles(shoesPage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices));
        LOG.info("items sorted success");


    }

    @Test
    public void addItemToWishList() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);


        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToWishListVANQUISH3();
        LOG.info("add to wish list button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");

    }

   @Test
    public void updateQuantityInWishlist() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        WishLisPage wishLisPage = new WishLisPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();
        String itemsQuantity= "2";

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");
        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToWishListVANQUISH3();
        LOG.info("add to wishlist button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        homePage.wishlistLinkIsDisplayed();
        LOG.info("wishlist link is displayed");
        homePage.clickOnCloseBarNotification();
        homePage.waitForWishlistLinkBeAvailable(driver);
        waitFor(1);
        homePage.clickOnWishlistLink();
        wishLisPage.updateQuantity(itemsQuantity);
        wishLisPage.updateWishlistBtnIsDisplayed();
        wishLisPage.clickOnUpdateWishlistBtn();
        wishLisPage.checkProductSubtotal(itemsQuantity);
        LOG.info("update quantity in wishlist success");

    }

   @Test
    public void deleteItemInWishlist() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        WishLisPage wishLisPage = new WishLisPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");
        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToWishListVANQUISH3();
        LOG.info("add to wishlist button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        homePage.wishlistLinkIsDisplayed();
        LOG.info("wishlist cart link is displayed");
        homePage.clickOnCloseBarNotification();
        homePage.waitForWishlistLinkBeAvailable(driver);
        waitFor(1);
        homePage.clickOnWishlistLink();
        wishLisPage.removeBtnIsDisplayed();
        wishLisPage.clickOnRemoveBtn();
        wishLisPage.wishlistEmptyIsDisplayed();
        LOG.info("update quantity in cart success");

    }

    @Test
    public void addItemToCartInWishlist() {
        HomePage homePage = new HomePage(driver);
        DesktopsPage desktopsPage = new DesktopsPage(driver);
        WishLisPage wishLisPage = new WishLisPage(driver);


        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");
        homePage.hoverOverComputers(driver);
        homePage.waitForDesktopsToBeClickable(driver);
        homePage.clickOnDesktops();
        desktopsPage.clickOnAddToWishListVANQUISH3();
        LOG.info("add to wish list button click success");
        desktopsPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        homePage.wishlistLinkIsDisplayed();
        LOG.info("wishlist cart link is displayed");
        homePage.clickOnCloseBarNotification();
        homePage.waitForWishlistLinkBeAvailable(driver);
        waitFor(1);
        homePage.clickOnWishlistLink();
        LOG.info("items quantity to add to the cart is : "+wishLisPage.getItemsQuantity()+" item(s)");
        wishLisPage.addToCartCheckboxIsDisplayed();
        wishLisPage.clickOnAddToCartCheckbox();
        wishLisPage.addToCartBtnIsDisplayed();
        wishLisPage.clickOnAddToCartBtn();
        LOG.info("items quantity in cart is : "+homePage.getItemsQuantityInCart()+" item(s)");

    }

    @Test
    public void addItemToCompareList() {
        HomePage homePage = new HomePage(driver);
        NotebooksPage notebooksPage = new NotebooksPage(driver);


        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForNotebooksToBeClickable(driver);
        homePage.clickOnNotebooks();
        notebooksPage.clickOnAddToCompareListMacBook();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        notebooksPage.clickOnAddToCompareListAsus();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        waitFor(1);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        notebooksPage.clickOnAddToCompareListHP();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");

    }
    @Test
    public void clearCompareProductsList() {
        HomePage homePage = new HomePage(driver);
        NotebooksPage notebooksPage = new NotebooksPage(driver);
        CompareProductsPage compareProductsPage = new CompareProductsPage(driver);


        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForNotebooksToBeClickable(driver);
        homePage.clickOnNotebooks();
        notebooksPage.clickOnAddToCompareListMacBook();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        notebooksPage.clickOnAddToCompareListAsus();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        waitFor(1);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        notebooksPage.waitForProductComparisonLinkToBeClickable(driver);
        notebooksPage.clickOnProductComparisonLink();
        LOG.info("product comparison link click success");
        compareProductsPage.clearListBtnIsDisplayed();
        compareProductsPage.clickOnClearListBtn();
        LOG.info("clear list button click success");
        compareProductsPage.compareListEmptyIsDisplayed();
        LOG.info("compare list empty is displayed");

    }

    @Test
    public void  deleteItemInCompareList(){
        HomePage homePage = new HomePage(driver);
        NotebooksPage notebooksPage = new NotebooksPage(driver);
        CompareProductsPage compareProductsPage = new CompareProductsPage(driver);


        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();


        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.computersLinkIsDisplayed();
        LOG.info("computers link is displayed");

        homePage.hoverOverComputers(driver);
        homePage.waitForNotebooksToBeClickable(driver);
        homePage.clickOnNotebooks();
        notebooksPage.clickOnAddToCompareListMacBook();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        notebooksPage.clickOnAddToCompareListAsus();
        LOG.info("add to compare list button click success");
        notebooksPage.waitForBarNotificationSuccessBeAvailable(driver);
        notebooksPage.barNotificationSuccessIsDisplayed();
        LOG.info("bar notification success is displayed");
        notebooksPage.waitForProductComparisonLinkToBeClickable(driver);
        waitFor(1);
        notebooksPage.clickOnProductComparisonLink();
        LOG.info("product comparison link click success");
        compareProductsPage.clickOnRemoveBtn();
        LOG.info("remove button click success");
        compareProductsPage.clickOnRemoveBtn();
        LOG.info("remove button click success");
        compareProductsPage.compareListEmptyIsDisplayed();
        LOG.info("compare list empty is displayed");

    }

}
