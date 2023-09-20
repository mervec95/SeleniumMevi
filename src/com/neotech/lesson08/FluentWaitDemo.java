package com.neotech.lesson08;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.neotech.utils.BaseClass;

public class FluentWaitDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		//http://webdriveruniversity.com/Ajax-Loader/index.html

		setUp();
		
		//We may combine implicit and fluent wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("button1")));
		
		WebElement span = driver.findElement(By.id("button1"));
		System.out.println("span is visible: " + span.isDisplayed());
		
		Thread.sleep(3000);
		
		//NOTES: 95% of our test can be handles via explicit wait
		
		
		tearDown();
		

	}

}
