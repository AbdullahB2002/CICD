package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest  extends BaseTest {
	 @Test
	    public void verifyLogin() {
	        driver.get("https://opensource-demo.orangehrmlive.com/");

	        LoginPage login = new LoginPage(driver);

	        login.loginToOrangeHRM("Admin", "admin123");

	        // Validation: URL should change after login
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("After Login URL: " + currentURL);

	        Assert.assertTrue(currentURL.contains("dashboard"),
	                "Login failed — dashboard not found!");
	    }
}
