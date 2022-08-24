package com.qa.facebook.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.facebook.base.BasePage;
import com.qa.facebook.constants.Constants;
import com.qa.facebook.pages.LoginPage;
import com.qa.facebook.util.TimeUtil;

public class LoginPageTest {
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver); 			
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() throws Exception {
		TimeUtil.mediumWait();
		String title = loginPage.getLoginPageTitle();
		System.out.println("The login Page title is::"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void verifyCreateNewAccountBtnDisplayedTest() {
		Assert.assertTrue(loginPage.verifyCreateNewAccountBtnDisplayed());
	}
	
	@Test(priority=3)
	public void verifyTestWithCorrectCredentials() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
	
	
	
	
	
	
	
	

}
