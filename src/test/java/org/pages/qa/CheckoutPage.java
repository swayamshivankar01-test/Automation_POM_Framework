package org.pages.qa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "termsofservice")
    WebElement termsCheckbox;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//input[@value='Checkout as Guest']")
    WebElement guestCheckoutButton;

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@onclick='Billing.save()']")
    WebElement billingContinue;

    @FindBy(css = "input[onclick='Shipping.save()']")
    WebElement shippingAddrContinue;

    @FindBy(css = "input[onclick='ShippingMethod.save()']")
    WebElement shippingContinue;

    @FindBy(id = "paymentmethod_0")
    WebElement cashOnDelivery;

    @FindBy(css = "input[onclick='PaymentMethod.save()']")
    WebElement paymentContinue;

    @FindBy(css = "input[onclick='PaymentInfo.save()']")
    WebElement paymentInfoContinue;

    @FindBy(xpath = "//input[@value='Confirm']")
    WebElement confirmButton;

    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this); // ✅ initializes all @FindBy fields
    }

    public void proceedToCheckout() {
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
        checkoutButton.click();
    }

    public void continueAsGuest() {
        wait.until(ExpectedConditions.elementToBeClickable(guestCheckoutButton));
        guestCheckoutButton.click();
    }

    public void enterShippingDetails(
            String userFirstName,
            String userLastName,
            String userEmail,
            String userCity,
            String userAddress,
            String userZip,
            String userPhone) {

        wait.until(ExpectedConditions.visibilityOf(firstName));

        firstName.clear();
        firstName.sendKeys(userFirstName);

        lastName.clear();
        lastName.sendKeys(userLastName);

        email.clear();
        email.sendKeys(userEmail);

        new Select(country).selectByVisibleText("India");

        city.clear();
        city.sendKeys(userCity);

        address1.clear();
        address1.sendKeys(userAddress);

        zipCode.clear();
        zipCode.sendKeys(userZip);

        phoneNumber.clear();
        phoneNumber.sendKeys(userPhone);
    }

    public void clickContinueButton() {
        billingContinue.click();
    }

    public void continueShippingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingAddrContinue));
        shippingAddrContinue.click();
    }

    public void continueShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinue));
        shippingContinue.click();
    }

    public void selectPaymentMethod() {
        cashOnDelivery.click();
        paymentContinue.click();
    }

    public void continuePaymentInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinue));
        paymentInfoContinue.click();
    }

    public void clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText();
    }
}