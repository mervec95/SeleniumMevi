package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class ImplicitWaitDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		
		//http://webdriveruniversity.com/Ajax-Loader/index.html
		setUp();
		
		//Defining an implicit wait of 30 seconds:
		//This wait is valid for the lifetime of the driver
		//If the element is not found, driver waits up the 30 seconds
		//after 30 seconds, an exception will be thrown
		//If the element is found before 30 seconds, the execution continues
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		

		//Using Thread.sleep(10000) will wait me for ten seconds
		//Thread.sleep(10000);
		
		WebElement span = driver.findElement(By.id("button1"));
		Thread.sleep(1000);

		// WebElement notExist = driver.findElement(By.id("ne1"));

		span.click();
		Thread.sleep(5000);

		tearDown();
	}

}


