package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

//Homework 1: Use WebDriverWait
//Verify element is enabled
//Open chrome browser
//Go to "https://the-internet.herokuapp.com/"
//Click on the "Dynamic Controls" link
//Click on enable button
//Enter "Hello" and verify text is entered successfully
//Close the browser
public class HW08Part01 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click();
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
		Thread.sleep(500);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='text']"))));
		
		
		WebElement we1 = driver.findElement(By.cssSelector("input[type='text']"));
		we1.click();
		Thread.sleep(5000);
		we1.sendKeys("Hello");
		
		if(we1.isDisplayed()) {
			System.out.println("Test is pass!");
		}else {
			System.out.println("Test is fail!");
		}
		
	//	tearDown();
		

		
		
	}

}
