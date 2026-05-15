package org.pages.qa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    WebDriver driver;

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "input.search-box-button")
    WebElement searchButton;

    @FindBy(css = ".product-title a")
    WebElement firstProductLink;

    @FindBy(css = "[id^='add-to-cart-button-']")
    WebElement addToCartButton;

    @FindBy(css = "#bar-notification p")
    WebElement successNotification;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void selectFirstProduct() {
        firstProductLink.click();
    }
    
    public String getFirstProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstProductLink));
        
        return firstProductLink.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getSuccessMessage() {
        return successNotification.getText();
    }
}