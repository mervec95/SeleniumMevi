package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//==================  HW_1_Handling Multiple Windows =======================
//
//1) Launch the browser and open the site "http://demo.guru99.com/popup.php" =====
//2) Click on link "Click Here". When the user clicks on the "Click Here" link, new child window opens. =====
//3) On the Child Window, Enter your email ID and submit. =====
//4) Then Access Credentials will be Displayed on submitted page. You will see the child window is open in new tab. =====
//5) Close the Child window on which credentials are displayed.Switch to the parent window. =====
//6) Quit all browsers =====
import com.neotech.utils.BaseClass;

public class HW07Part01 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		

		setUp();
		Thread.sleep(500);

		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set <String> handles = driver.getWindowHandles(); 
		
		Iterator <String> i = handles.iterator();
		
		String parent = i.next();
		String child = i.next();
		
		driver.switchTo().window(child);
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys("mervec@yahoo.com");
		
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		Thread.sleep(500);
		
		WebElement ac = driver.findElement(By.xpath("//tbody"));
		ac.isDisplayed();
		
		if(ac.isDisplayed())
		{
			System.out.println("Test is pass!");
		}else {
			System.out.println("Test is fail!");
		}
		
				driver.close();
				Thread.sleep(1000);
				
				driver.switchTo().window(parent);
				
				Thread.sleep(1000);
		
		//tearDown();

	}

}
