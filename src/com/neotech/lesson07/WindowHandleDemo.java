package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class WindowHandleDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// https://accounts.google.com/signup
		
		setUp();
		
		Thread.sleep(1000);
		
		System.out.println("Title -> " + driver.getTitle());
		
		//Tjis will give us a unique ID for this window/tab
		System.out.println("Handle -> " + driver.getWindowHandle());
		
		driver.findElement(By.linkText("Help")).click();
		
		Thread.sleep(1000);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		System.out.println("The number of open window/tabs -> " + allWindowHandles.size());

		Iterator<String> it = allWindowHandles.iterator();
		String window1 = it.next();
		String window2 = it.next();
		
		System.out.println("Window1 -> " + window1);
		System.out.println("Window2 -> " + window2);
		
		//Switching to window 2
		driver.switchTo().window(window2);
		
		//Get the title of the window we switched to
		String title2 = driver.getTitle();
		System.out.println("Title -> " + title2);
		
		Thread.sleep(2000);
		
		//This will only close the focused tab/window
		driver.close();
		Thread.sleep(2000);
		
		tearDown();
		
		
		

	}

}
