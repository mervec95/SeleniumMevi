package com.neotech.lesson05;

//Orange HRM Application Login:
//Open Chrome browser
//Go to https://hrm.neotechacademy.com/
//Enter valid username and password
//Click on login button
//Then verify that "span with id account-name" has the text "Jacqueline White".
//Quit the browser

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Open Chrome browser
//Go to https://hrm.neotechacademy.com/
//Enter valid username and password
//Click on login button
//Then verify that "span with id account-name" has the text "Jacqueline White".
//Quit the browser

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class HW05Part01 extends BaseClass {
	
	public static void main(String[] args) throws Exception {
		
		setUp();
		
	    driver.findElement(By.cssSelector("#txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
	    Thread.sleep(200);
	    driver.findElement(By.cssSelector("#txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
	    Thread.sleep(200);
	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	    Thread.sleep(1000);
		
	    WebElement an = driver.findElement(By.cssSelector("#account-name"));
	    
	    if(an.getText().equalsIgnoreCase("Jacqueline White")) {
	    	System.out.println("Account name is: " + an.getText() + " -> Test passed!");
	    }else {
	    	System.out.println("Failed!");
	    }

	    
	   // tearDown();
	}
}
