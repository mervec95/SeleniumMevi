package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class ExplicitWaitDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		//http://webdriveruniversity.com/Ajax-Loader/index.html

		setUp();
		
		//We are creating a WebDriverWait object with max wait time 20 sec.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		//We are defining a condition for which element to wait 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("button1"))));
		
		//or i can use
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button1")));
		
		WebElement span = driver.findElement(By.id("button1"));
		System.out.println("span is visible: " + span.isDisplayed());
		
		Thread.sleep(3000);
		tearDown();

	}

}
