package org.tests.qa;

import org.listeners.qa.TestListener;
import org.pages.qa.CartPage;
import org.pages.qa.ProductDetailsPage;
import org.pages.qa.CheckoutPage;
import org.utilities.qa.BrowserManage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(org.listeners.qa.TestListener.class)

public class CheckoutTest extends BrowserManage {

    String productToSearch =
            "Computing and Internet";

    public CheckoutTest()
            throws IOException {

        super();
    }

    @Test
    public void guestCheckoutFlowTest() throws InterruptedException {

        ProductDetailsPage pp =new ProductDetailsPage(driver);

        pp.searchProduct(productToSearch);

        pp.selectFirstProduct();

        pp.addToCart();
        CartPage cp =new CartPage(driver);

        cp.goToCart();

        CheckoutPage checkout =new CheckoutPage(driver);

        checkout.proceedToCheckout();

        checkout.continueAsGuest();

        checkout.enterShippingDetails(
                "John",
                "Doe",
                "john.doe@test.com",
                "New York",
                "123 Liberty St",
                "10001",
                "1234567890"
        );

        checkout.clickContinueButton();

        checkout.continueShippingAddress();

        checkout.continueShippingMethod();

        checkout.selectPaymentMethod();

        checkout.continuePaymentInfo();

        checkout.clickConfirmButton();

        String actualMsg =checkout.getConfirmationMessage();

        String expectedMsg ="Your order has been successfully processed!";

        Assert.assertTrue(
                actualMsg.contains(expectedMsg));
    }
}