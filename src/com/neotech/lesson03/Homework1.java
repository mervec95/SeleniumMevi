package com.neotech.lesson03;
//HW1:
//Open chrome browser
//Go to "https://demo.guru99.com/test/newtours/"
//Click on Register Link
//Fill out ALL required info
//Click Submit
//User successfully registered
//(Create the script using different locators)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

	public final static String url = "https://demo.guru99.com/test/newtours/";
	
	public static void main(String[] args) throws InterruptedException {
		
		
		//decide which browser we are using and the correct driver location
		System.getProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//we find elements with: driver.findElement( - how to find it - );
		
		//clock on the Register link: 
		driver.findElement(By.partialLinkText("REGIS")).click();
		
		//doing this in two steps
		//WebElement register = driver.findElement(By.linkText("REGISTER"));
		//register.click();
		
		//filling out the form
		driver.findElement(By.name("firstName")).sendKeys("John");
		driver.findElement(By.name("lastName")).sendKeys("Smith");
		driver.findElement(By.name("phone")).sendKeys("000");
		driver.findElement(By.id("userName")).sendKeys("Js@gmail.com");
		
		//address info
		driver.findElement(By.name("address1")).sendKeys("123 prospect st");
		driver.findElement(By.name("city")).sendKeys("NYC");
		driver.findElement(By.name("state")).sendKeys("NY");
		driver.findElement(By.name("postalCode")).sendKeys("00007");
		
		//user details
		driver.findElement(By.id("email")).sendKeys("john123");
		driver.findElement(By.name("password")).sendKeys("john123");
		driver.findElement(By.name("confirmPassword")).sendKeys("john123");
		
		
		
		//just so that we can slow down the execution to see that the information is filled out
		Thread.sleep(2000);
		
		//driver.findElement(By.name("submit")).click(); 
		Thread.sleep(5000);
		
		//check if it went to the success register page: https://demo.guru99.com/test/newtours/
		
		String expectedUrl = "https://demo.guru99.com/test/newtours/";
		
		String actualUrl = driver.getCurrentUrl();
		if(expectedUrl.equalsIgnoreCase(actualUrl))
		{
			System.out.println("Test passed!");
		}
		else
		{
			System.out.println("Test failed!");
		}
		//driver.quit();
		

		
		

	}

}
