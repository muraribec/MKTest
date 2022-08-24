package com.qa.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.facebook.base.BasePage;

public class LoginPage extends BasePage{
	
	
	//1]PageObject --> PageFactory
	
	@FindBy(id="email")
	WebElement emailTextBox;
	
	@FindBy(name="pass")
	WebElement passwordTextBox;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	@FindBy(xpath="(//*[@role='button'])[2]")
	WebElement createNewAccountBtn;
	
	//2]Single Argumented Constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//3]Member Function --> PageAction --> Page Library
	
	public boolean verifyCreateNewAccountBtnDisplayed() {
		return createNewAccountBtn.isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void doLogin(String userName, String password) {
		System.out.println("Credentials"+userName +"/"+password);
		emailTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		loginButton.click();	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
