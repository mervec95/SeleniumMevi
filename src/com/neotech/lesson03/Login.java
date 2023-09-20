package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public final static String url = "http://neotechacademy-sis.com:9000/Test/";

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		//send username and password and submit
		
		driver.findElement(By.id("tUsername")).sendKeys("Admin");
		driver.findElement(By.id("tPassword")).sendKeys("Neotech$123");
		
		Thread.sleep(2000);
		driver.findElement(By.id("bLogin")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Students")).click();
		
		
		
		driver.quit();

	}

}
