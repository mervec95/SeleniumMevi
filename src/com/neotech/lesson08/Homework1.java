package com.neotech.lesson08;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

//==================  HW_1_Handling Multiple Windows =======================
//
//1) Launch the browser and open the site "http://demo.guru99.com/popup.php" 
//2) Click on link "Click Here". When the user clicks on the "Click Here" link, new child window opens. 
//3) On the Child Window, Enter your email ID and submit. 
//4) Then Access Credentials will be Displayed on submitted page. You will see the child window is open in new tab. 
//5) Close the Child window on which credentials are displayed.Switch to the parent window. 
//6) Quit all browsers 
public class Homework1 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(1000);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		// String thirdWindow = it.next(); //Exception: runtime error

		// We need to change the focus to the child window/tab
		driver.switchTo().window(childWindow);

		// Locate the input element in child page
		driver.findElement(By.xpath("/input[@name='emailid']")).sendKeys("test@me.com");

		// Locate the button
		driver.findElement(By.name("btnLogin")).click();

		// Get the user name
		String userId = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();

		// Get the password
		String password = driver.findElement(By.xpath("//tr[5]/td[2]")).getText();

		System.out.println("User ID: " + userId);
		System.out.println("Password: " + password);

		// How to switch back to the parent tab?
		// Leave the child page by calling driver.close()
		// Switch to the parent window

		driver.close();
		// driver.switchTo().window(parentWindow);

		Thread.sleep(5000);
		tearDown();

	}

}