package com.qa.facebook.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.facebook.base.BasePage;
import com.qa.facebook.pages.HomePage;
import com.qa.facebook.pages.LoginPage;
import com.qa.facebook.util.ExcelUtil;
public class LoginPageTestWithDP {
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
	@DataProvider(name="getContactsData")
	public Object[][] getContactData()
	{
		Object contactsData[][] = ExcelUtil.getTestData("contacts");
	 	return contactsData;		 
	}
	@Test(dataProvider="getContactsData")
	public void createNewContactTest(String eamil,String firstName,String lastName,String jobTitle){
		//contactsPage.createNewContacts(eamil,firstName,lastName,jobTitle);
		System.out.println(eamil);
		loginPage.doLogin(eamil, firstName);		
	}	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
