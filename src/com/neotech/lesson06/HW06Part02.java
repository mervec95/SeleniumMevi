package com.neotech.lesson06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import com.neotech.utils.BaseClass;

//Homework 2:
//    Alert text verification
//    Open chrome browser
//    Go to https://demoqa.com/
//    Click on "Alerts, Frame & Windows" link
//    Click on "Alerts" links on the left side
//    Click on button to see Alert
//    Verify alert box with text "You clicked a button" is present
//    Click on 3rd button in the page
//    Verify alert box with text "Do you confirm action?" is present and click "confirm"
//    Click on 4 th button in the page and enter your name and click ok.
//    Quit browser
public class HW06Part02 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Thread.sleep(300);
		
		
		Alert al = driver.switchTo().alert();
		String actualoutput = al.getText();
		String expectedoutput = "You clicked a button";
		if(actualoutput.equalsIgnoreCase(expectedoutput)) {
			System.out.println("Test is pass!");
		}else {
			System.out.println("Test is fail!");
		}
		Thread.sleep(500);
		al.accept();
		Thread.sleep(1000);
		
		
		driver.findElement(By.cssSelector("#confirmButton")).click();
		Thread.sleep(300);
		Alert confirm = driver.switchTo().alert();
		String actualoutput1 = confirm.getText();
		String expectedoutput1 = "Do you confirm action?";
		
		if(actualoutput1.equalsIgnoreCase(expectedoutput1)) {
			System.out.println("Test is pass!");
		}else {
			System.out.println("Test is fail!");
		}
		confirm.accept();
		Thread.sleep(1000);
	
		
		
		driver.findElement(By.cssSelector("#promtButton")).click();
		Thread.sleep(300);
		
		Alert promt = driver.switchTo().alert();
		promt.sendKeys("Merve");
		Thread.sleep(5000);
		promt.accept();
		
		//tearDown();
		
	}

}
