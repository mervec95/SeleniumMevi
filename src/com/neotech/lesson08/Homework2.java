package com.neotech.lesson08;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Homework2 extends BaseClass {

//	=================   HW_2_Handling Frames =================================
//
//	1) Launch the browser and open the site "https://chercher.tech/practice/frames-example-selenium-webdriver"
//	2) Verify on the page header "Not a Friendly Topic" displayed
//	3) Click on the Inner Frame Check box
//	4) Choose baby Cat from Animals dropdown
//	5) Quit the browser
	public static void main(String[] args) throws InterruptedException {

		setUp();

		String label = driver.findElement(By.xpath("//label/span")).getText();
		System.out.println(label);

		System.out.println(label == "Not a Friendly Topic");

		// Moving inside the first frame
		driver.switchTo().frame("frame1");

		// Moving inside the inner frame
		driver.switchTo().frame(0);
		// driver.switchTo().frame("frame3");

		// Now lets find the check box and click it
		driver.findElement(By.id("a")).click();

// Switch the focus back to the main page
		driver.switchTo().defaultContent();

		// Switch into the frame by using its name or index
		driver.switchTo().frame("frame2");
		// driver.switchTo().frame(1);

		// locale the select element
		Select sel = new Select(driver.findElement(By.id("animals")));
		sel.selectByVisibleText("Baby Cat");

		Thread.sleep(3000);

		tearDown();

	}

}