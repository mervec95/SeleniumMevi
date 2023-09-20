package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//HW2: Facebook sign up:
//Open chrome browser
//Go to "https://www.facebook.com/"
//Click on Sign Up link
//Enter first name
//Enter last name
//Enter email address
//Re-enter email address
//Click on Sign Up button   

public class Homework2 {

	public final static String url = "https://www.facebook.com/";
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("url");
		
		
		driver.findElement(By.linkText("Create new account")).click();
		
		//the code is way faster than the page/internet
		//so it could happen that it does not find a certain element
		//for now: we will use Thread.sleep();
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstname")).sendKeys("John");
		driver.findElement(By.name("lastname")).sendKeys("Wick");
		
		driver.findElement(By.name("reg_email__")).sendKeys("jw@gmail.com");
		
		Thread.sleep(2000);
		
		//when we fill out the email, another email confirmation box shows
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("jw@gmail.com");
		
		driver.findElement(By.id("password_step_input")).sendKeys("jw123");
		
		//driver.findElement(By.name("websubmit")).click();
		
		Thread.sleep(5000);
		
		

	}

}
