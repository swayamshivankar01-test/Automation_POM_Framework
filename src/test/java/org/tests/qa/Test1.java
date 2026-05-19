package org.tests.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void get() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.close();
	}
	
}
