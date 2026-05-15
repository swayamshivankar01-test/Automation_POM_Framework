package org.pages.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "Email")
    WebElement usernameField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(className = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

    public void username(String un) {
        usernameField.clear();
        usernameField.sendKeys(un);
    }

    public void password(String pwd) {
        passwordField.clear();
        passwordField.sendKeys(pwd);
    }

    public void Login_btn() {
        loginButton.click();
    }

    public void login(String un, String pwd) {
        username(un);
        password(pwd);
        Login_btn();
    }
}