package com.neotech.lesson08;
//Homework 2: Use FluentWait

//Verify element is enabled
//Open chrome browser
//Go to "https://the-internet.herokuapp.com/"
//Click on the "Dynamic Controls" link
//Click on enable button
//Enter "Hello" and verify text is entered successfully
//Close the browser

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class HW08Part02 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click();
		Thread.sleep(500);

		driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
		Thread.sleep(500);

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(15))
				.ignoring(NoSuchElementException.class);

		WebElement we1 = driver.findElement(By.cssSelector("input[type='text']"));
		we1.click();
		Thread.sleep(5000);
		we1.sendKeys("Hello");

		if (we1.isDisplayed()) {
			System.out.println("Test is pass!");
		} else {
			System.out.println("Test is fail!");
		}

		//tearDown();

	}

}
