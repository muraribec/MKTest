package com.qa.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.facebook.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Murari Kumar
 *
 */
public class BasePage {
	
	public Properties prop;
	public WebDriver driver;
	
	/**
	 * This method is used to Initialize the WebDriver
	 * @param prop
	 * @return WebDriver
	 */
	
	public WebDriver initialize_driver(Properties prop ) {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else if (browserName.equals("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();			
		}else {
			System.out.println("Browser"+ browserName +"is not define in the properties file,please give the proper browser name");
		}		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		return driver;		
	}
	/**
	 * This method used to Initialize the Properties and return the properties reference
	 * @return prop
	 */
	public Properties initialize_Properties() {
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace1\\Project_Batch8pm\\src\\main\\java\\com\\qa\\facebook\\configuration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return prop;
	}

}
