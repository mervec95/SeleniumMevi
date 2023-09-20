package com.neotech.lesson09;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class Homework1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Homework 1: Use WebDriverWait Verify element is enabled 
		 * Open chrome browser
		 * Go to "https://the-internet.herokuapp.com/" 
		 * Click on the "Dynamic Controls" link 
		 * Click on enable button 
		 * Enter "Hello" and verify text is entered successfully 
		 * Close the browser
		 */
		
		setUp();
		
		//implicit wait:
			//- we declare it once
			//- will be applied to every findElement(), findElements() call
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//go to Dynamic Controls
		driver.findElement(By.linkText("Dynamic Controls")).click();
		//click on Enable button
		driver.findElement(By.xpath("//form[@id= 'input-example']/button")).click();
		
		//situation:
		//Element is there, but is inactive (not interactable)
		
		//define a WebDriverWait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textBox = driver.findElement(By.xpath("//form[@id= 'input-example']/input"));
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		
		
		textBox.sendKeys("Emre");
		
		
		
		Thread.sleep(5000); //the only purpose is so that I can see the screen
		tearDown();
		
	}

}