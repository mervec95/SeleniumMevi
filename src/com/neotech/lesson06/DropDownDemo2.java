package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class DropDownDemo2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		//https://demoqa.com/select-menu
			
		
		setUp();
		
		//we locate the element
		WebElement oldMenu = driver.findElement(By.id("oldSelectMenu"));
		

		//create select object using the WebElement of the select tag
		Select selDD = new Select(oldMenu);
		
		selDD.selectByIndex(1);
		Thread.sleep(3000);
		
		WebElement otherMenu = driver.findElement(By.id("withOptGroup"));
		otherMenu.click();
		
		Thread.sleep(3000);
		
		tearDown();
		
		
	}

}
