package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case
// Open chrome browser
// Go to “https://demo.guru99.com/test/newtours/”
// Click on Register Link
//
// Fill out just
// First Name:
// Last Name:
// Phone:
// Email:
// And Click Submit

public class Task {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("firstName")).sendKeys("June");
		driver.findElement(By.name("lastName")).sendKeys("Liu");
		driver.findElement(By.name("phone")).sendKeys("000"); //sitede ustune sag tikla inpect de sonra orda nasil yazilmissa onu kopyala buraya yapistir
		driver.findElement(By.id("email")).sendKeys("user.name");
		
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		

	}

}
