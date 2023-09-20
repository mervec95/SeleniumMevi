package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.utils.BaseClass;

public class NestedFrames extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		

		// https://demoqa.com/nestedframes/
		
		setUp();
		
		//Switch to the Parent Frame
		driver.switchTo().frame("frame1"); //using the id of the frame
		Thread.sleep(1000);
		
		//Locating the Child Frame
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		
		//Switching inside the Child Frame, using the WebElement
		driver.switchTo().frame(childFrame);
		
		//Now my focus is inside the Child Frame
		WebElement p = driver.findElement(By.xpath("//body/p"));
	    String text = p.getText();
	    
	    System.out.println("The text inside the child frame -> " + text);
	    
	    Thread.sleep(3000);
		
	    //Now my focus is inside the Child Frame
	    
	    //The focus will switch to the Main Page
	    driver.switchTo().defaultContent();
		
		tearDown();
		

	}

}
