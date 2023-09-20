package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
	//Tester - test
//	Open chrome browser
//	Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
//	Enter valid username and password
//	Click on login button
//	Then verify "Web Orders" is displayed and also username is displayed right top corner

	public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	public static String username = "Tester";
	public static String password = "test";

	public static void main(String[] args) throws InterruptedException {
//		Open chrome browser
//		Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
//		Enter valid username and password
//		Click on login button
//		Then verify "Web Orders" is displayed and also username is displayed right top corner

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		// send username and password
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);

		// login
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(2000);

		// Locate the header
		WebElement header = driver.findElement(By.tagName("h1"));
		if (header.isDisplayed()) {
			System.out.println("The header " + header.getText() + " is displayed!");
		} else {
			System.out.println("The header is NOT displayed!");
		}
		
		// Locate the div which has the username 
		String loginText = driver.findElement(By.cssSelector("div.login_info")).getText();
		if (loginText.contains("Tester")) {
			System.out.println("Tester is logged in correctly!");
		}else {
			System.out.println("It failed!");
		}

		driver.quit();
	}

}