package com.neotech.lesson06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class AlertDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		// https://demo.guru99.com/test/delete_customer.php
		
		
				setUp();
				
				driver.findElement(By.name("cusid")).sendKeys("12345");
				driver.findElement(By.name("submit")).click();
				
				Thread.sleep(2000);
				
				//shift focus from the webpage to the shown alert
				Alert simpleAlert = driver.switchTo().alert();
				Thread.sleep(2000);
				String alertText = simpleAlert.getText();
				System.out.println("The simple alert text is: " + alertText);
				simpleAlert.dismiss();
				
				
				
				
				//lets click again to delete customer
				driver.findElement(By.name("submit")).click();
				Thread.sleep(2000);
				Alert secondAlert = driver.switchTo().alert();
				
				Thread.sleep(2000);
				secondAlert.accept();
				
				//going to another Alert
				Alert lastConfirmationAlert = driver.switchTo().alert();
				System.out.println(lastConfirmationAlert.getText());
				lastConfirmationAlert.accept();
				
				
				
				
				Thread.sleep(2000);
				
				tearDown();
			}

		}