package com.neotech.lesson09;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// Same task as Hw1, but use FluentWait

		
		setUp();
		//implicit wait:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		//click on Enable button
		driver.findElement(By.xpath("//form[@id= 'input-example']/button")).click();
		
		
		//FluentWait
		
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		
		fluentWait.withTimeout(Duration.ofSeconds(10));
		fluentWait.pollingEvery(Duration.ofSeconds(2));
		//We have the ability to ignore a certain exception
		fluentWait.ignoring(NoSuchElementException.class);
		
		
		WebElement textBox = driver.findElement(By.xpath("//form[@id= 'input-example']/input"));
				
		fluentWait.until(ExpectedConditions.elementToBeClickable(textBox));
		
		
		
		textBox.sendKeys("Merve");
		Thread.sleep(3000);
		
		
		System.out.println(textBox.getAttribute("value"));
		
		
		tearDown();
	}

}