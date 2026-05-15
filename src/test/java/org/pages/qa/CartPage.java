package org.pages.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    WebDriver driver;

    @FindBy(className = "ico-cart")
    WebElement cartLink;

    @FindBy(css = ".cart-item-row .product-name a")
    WebElement firstCartItemName;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCart() {
        cartLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.urlContains("/cart"));
    }

    public String getFirstItemName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart td.product a")));
        return item.getText();
    }
}