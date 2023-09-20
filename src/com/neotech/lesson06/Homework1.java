package com.neotech.lesson06;
/*
 * Orange HRM Application Login: 
 * Open Chrome browser 
 * Go to https://hrm.neotechacademy.com/ 
 * Enter valid username and password 
 * Click on login button 
 * Then verify that "span with id account-name" has the text
 * "Jacqueline White". 
 * Quit the browser
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class Homework1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
	
		//set up the browser
		setUp();
		//Declaring driver location
		//Initializing ConfigsReader
		//Initialize the driver
		//Go to URL

		//Where are my credentials??? config.properties
		String username = ConfigsReader.getProperty("username");
		String password = ConfigsReader.getProperty("password");
		
		System.out.println(username + " " + password);
		
		WebElement usernameBox = driver.findElement(By.id("txtUsername"));
		WebElement passwordBox = driver.findElement(By.id("txtPassword"));
		WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
		
		//send credentials to the boxes
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginBtn.click();
		
		Thread.sleep(3000);
		
		String expected = "Jacqueline White";
		String actual = driver.findElement(By.id("account-name")).getText();
		
		
		if(expected.equals(actual))
		{
			System.out.println("Test passed!");
		}
		else
		{
			System.out.println("Test failed!");
		}
		
		Thread.sleep(3000);
		//close the browser
		tearDown();

	}

}