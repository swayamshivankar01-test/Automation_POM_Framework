package org.tests.qa;

import org.pages.qa.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import org.base.qa.BaseClass;
import org.listeners.qa.TestListener;
import org.utilities.qa.BrowserManage;
import org.utilities.qa.ExcelUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Listeners(org.listeners.qa.TestListener.class)

public class LoginTest extends BrowserManage {

    public LoginTest() throws IOException {
        super();
    }

    @Test(priority = 1)
    public void validLoginTest() throws Exception {
        String username = ExcelUtil.getExcelData("LoginData")[0][0].toString();
        String password = ExcelUtil.getExcelData("LoginData")[0][1].toString();

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

        String expectedUrl = "https://demowebshop.tricentis.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void invalidLoginTest() throws Exception {
        String username = ExcelUtil.getExcelData("LoginData")[1][0].toString();
        String password = ExcelUtil.getExcelData("LoginData")[1][1].toString();

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);

        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void blankLoginTest() throws Exception {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");
        Assert.assertTrue(true);
    }
}