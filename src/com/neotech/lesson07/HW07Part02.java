package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//=================   HW_2_Handling Frames =================================
//
//1) Launch the browser and open the site "https://chercher.tech/practice/frames-example-selenium-webdriver" =====
//2) Verify on the page header "Not a Friendly Topic" displayed ======
//3) Click on the Inner Frame Check box =====
//4) Choose baby Cat from Animals dropdown =====
//5) Quit the browser ======
import com.neotech.utils.BaseClass;

public class HW07Part02 extends BaseClass { 

	public static void main(String[] args) throws InterruptedException {

		setUp();
		Thread.sleep(1000);

		WebElement Text = driver.findElement(By.xpath("//span[contains(text(),'Not a Friendly Topic')]"));
		Text.isDisplayed();

		String actualText = Text.getText();
		String expectedText = "Not a Friendly Topic";

		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Actual text is same expected Text");
		} else {
			System.out.println("Actual text is NOT same expected Text");
		}
		Thread.sleep(1000);

		driver.switchTo().frame("frame1");
		Thread.sleep(500);

//		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
//		driver.switchTo().frame(frame3);
		driver.switchTo().frame("frame3");
		driver.findElement(By.cssSelector("#a")).click();
		Thread.sleep(500);

		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		//driver.switchTo().frame("frame2");
		
		Select animal = new Select(driver.findElement(By.id("animals")));
		animal.selectByVisibleText("Baby Cat");
		//tearDown();

	}

}


