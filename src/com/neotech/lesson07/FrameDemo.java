package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;

public class FrameDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// https://jqueryui.com/tooltip/

		setUp();

		Thread.sleep(1000);

		// This element is inside a Frame. We are not able to locate it!
		// driver.findElement(By.id("age"));

		// There are 3 ways to switch to the frame

		// 1st way, switch to frame by index
		driver.switchTo().frame(0); // switch to the frame with index
		WebElement ageTxt = driver.findElement(By.id("age"));
		ageTxt.sendKeys("Abril");
		Thread.sleep(1000);

		// This element is outside of the Frame. We are not able to locate it!
		// driver.findElement(By.linkText("Checkboxradio"));

		// We need to switch to the Main Page
		// This method with switch the focus to the Main Page
		driver.switchTo().defaultContent();

		// 2nd way, switch to frame by name or id
		// Our Frame does not have a name or id

		// 3rd way, switch to frame using a WebElement
		WebElement frameEl = driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(frameEl); // switch to the frame with WebElement

		// One liner
		// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		// Now we are inside the frame
		WebElement age = driver.findElement(By.id("age"));
		age.clear();
		Thread.sleep(1000);
		age.sendKeys("25");
		Thread.sleep(2000);

		// switch back outside the frame
		driver.switchTo().defaultContent();

		tearDown();
	}

}