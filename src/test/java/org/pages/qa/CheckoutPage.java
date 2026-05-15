package org.pages.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By termsCheckbox        = By.id("termsofservice");
    By checkoutButton       = By.id("checkout");
    By guestCheckoutButton  = By.xpath("//input[@value='Checkout as Guest']");
    By firstName            = By.id("BillingNewAddress_FirstName");
    By lastName             = By.id("BillingNewAddress_LastName");
    By email                = By.id("BillingNewAddress_Email");
    By country              = By.id("BillingNewAddress_CountryId");
    By city                 = By.id("BillingNewAddress_City");
    By address1             = By.id("BillingNewAddress_Address1");
    By zipCode              = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumber          = By.id("BillingNewAddress_PhoneNumber");
    By billingContinue      = By.xpath("//input[@onclick='Billing.save()']");
    By shippingAddrContinue = By.cssSelector("input[onclick='Shipping.save()']");
    By shippingContinue     = By.cssSelector("input[onclick='ShippingMethod.save()']");
    By cashOnDelivery       = By.id("paymentmethod_0");
    By paymentContinue      = By.cssSelector("input[onclick='PaymentMethod.save()']");
    By paymentInfoContinue  = By.cssSelector("input[onclick='PaymentInfo.save()']");
    By confirmButton        = By.xpath("//input[@value='Confirm']");
    By confirmationMessage  = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void proceedToCheckout() {
        WebElement terms = driver.findElement(termsCheckbox);
        if (!terms.isSelected()) {
            terms.click();
        }
        driver.findElement(checkoutButton).click();
    }

    public void continueAsGuest() {
        wait.until(ExpectedConditions.elementToBeClickable(guestCheckoutButton));
        driver.findElement(guestCheckoutButton).click();
    }

    public void enterShippingDetails(
            String userFirstName,
            String userLastName,
            String userEmail,
            String userCity,
            String userAddress,
            String userZip,
            String userPhone) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(userFirstName);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(userLastName);

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(userEmail);

        new Select(driver.findElement(country)).selectByVisibleText("India");

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(userCity);

        driver.findElement(address1).clear();
        driver.findElement(address1).sendKeys(userAddress);

        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(userZip);

        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(userPhone);
    }

    public void clickContinueButton() {
        driver.findElement(billingContinue).click();
    }

    public void continueShippingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingAddrContinue));
        driver.findElement(shippingAddrContinue).click();
    }

    public void continueShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinue));
        driver.findElement(shippingContinue).click();
    }

    public void selectPaymentMethod() {
        driver.findElement(cashOnDelivery).click();
        driver.findElement(paymentContinue).click();
    }

    public void continuePaymentInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinue));
        driver.findElement(paymentInfoContinue).click();
    }

    public void clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        driver.findElement(confirmButton).click();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return driver.findElement(confirmationMessage).getText();
    }
}