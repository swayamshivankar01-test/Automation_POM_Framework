package org.tests.qa;

import org.listeners.qa.TestListener;
import org.pages.qa.CartPage;
import org.pages.qa.ProductDetailsPage;
import org.utilities.qa.BrowserManage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(org.listeners.qa.TestListener.class)

public class SearchAndCartTest extends BrowserManage {

    String productToSearch = "Computing and Internet";

    public SearchAndCartTest() throws IOException {
        super();
    }

    @Test(priority = 1)
    public void searchProductTest() {
        ProductDetailsPage pp = new ProductDetailsPage(driver);
        pp.searchProduct(productToSearch);
        String actualProductTitle = pp.getFirstProductTitle();
        Assert.assertEquals(actualProductTitle, productToSearch);
    }

    @Test(priority = 2, dependsOnMethods = {"searchProductTest"})
    public void addProductToCartTest() {
        ProductDetailsPage pp = new ProductDetailsPage(driver);
        
        pp.searchProduct(productToSearch);
        pp.selectFirstProduct();
        pp.addToCart();

        String actualMsg = pp.getSuccessMessage();
        String expectedMsg = "The product has been added to your shopping cart";
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test(priority = 3, dependsOnMethods = {"addProductToCartTest"})
    public void verifyCartItemTest() {
        ProductDetailsPage pp = new ProductDetailsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.searchProduct(productToSearch);
        pp.selectFirstProduct();
        pp.addToCart();

        cp.goToCart();
        String actualCartItem = cp.getFirstItemName();
        Assert.assertEquals(actualCartItem, productToSearch);
    }
}