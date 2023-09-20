package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

//Homework 3:
//    Open chrome browser  ===
//    Go to "https://semantic-ui.com/modules/dropdown.html" ===
//    Scroll down to "Multiple Selection" ===
//    Click on drop down and select "CSS" and "HTML" ===
//    Verify value has been selected ===
//    Deselect 1 of the options from the dropdown ===
//    Quit browser ===
public class HW06Part03 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		Thread.sleep(500);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");

		driver.findElement(By.cssSelector("div[class='ui fluid dropdown selection multiple']")).click();
		Thread.sleep(500);

		WebElement selectCSS = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/div[4]/div[1]/div[8]/div[1]/div[2]/div[2]"));
		selectCSS.click();
		Thread.sleep(500);

		WebElement selectHTML = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/div[4]/div[1]/div[8]/div[1]/div[2]/div[5]"));
		selectHTML.click();
		Thread.sleep(500);

		boolean selectCSS1 = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/div[4]/div[1]/div[8]/div[1]/div[2]/div[2]")).isEnabled();
		if (selectCSS1 == true) {
			System.out.println("CSS is selected ");
		} else {
			System.out.println("CSS is NOT selected");
		}

		boolean selectHTML1 = driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/div[4]/div[1]/div[8]/div[1]/div[2]/div[2]")).isEnabled();
		if (selectHTML1 == true) {
			System.out.println("HTML is selected ");
		} else {
			System.out.println("HTML is NOT selected");
		}

		Thread.sleep(200);

		WebElement deleteCSS = driver.findElement(By.cssSelector("a[data-value='css'] i[class='delete icon']"));
		deleteCSS.click();
		Thread.sleep(500);

//		tearDown();

	}

}
