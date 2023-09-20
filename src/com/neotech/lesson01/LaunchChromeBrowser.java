package com.neotech.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		

		//we have added everything we need on the communication path
		   //we add selenium language binding (Selenium Java Libs)
		   //we added chromedriver
		//all we have to do now, is to use Selenium classes to call 
		   //the chrome driver and open/close the chrome browser
		
		//full path: /Users/merve/eclipse-workspace/Selenium5/drivers/chromedriver
		//relative path: drivers/chromedriver
		
		
		//if java cannot find our chromedriver location
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		//which driver I want to use, where that is located 
		
		//open the browser
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.neotechacademy.com/");
		
		//pause the execution for 5000 milliseconds -> 5 seconds
		Thread.sleep(5000);
		
		//close the browser
		driver.quit();
		
		//driver.close();
		
		
//		open the browser 		WebDriver driver = new ChromeDriver();
//		open this page		driver.get("https://www.neotechacademy.com/");
//			fill out the login info
//			click login
//			take a screenshot
//	quit the browser		driver.quit();
		
		
		
		//we created a project
		   //we added selenium Java libraries
		   //we added ChromeDriver
		   //we tested with chrome browser (not ChromeDriver, FirefoxDriver)
		
		
		
		
		
//		What is software testing?
//				- it is a process that intents to check the correctness and quality of the 
//				developed application
//				
//				
//			Two types: 
//				Manual Testing
//				Test Automation (Selenium)
//				
//
//
//			What is Selenium WebDriver?
//				It is an interface. This is a framework that allows for us to execute 
//				code that will test web apps in different browsers.
//				
//
//				
//			Code -------------------------------------------Browser---------- WebPage
//
//			Selenium Java Libs		---->  Driver ----->  Browser ---> we go to any page
//				ChromeDriver (C)			chromedriver	Chrome
//				FirefoxDriver (C)			geckodriver		Firefox
//				WebDriver (I)
//				
		

	}

}
