package com.neotech.lesson06;

import java.util.List;
//ERRORLU KOD
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class MultipleSelectDropdown extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		//https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
		
		setUp();
		
		WebElement multiSelect = driver.findElement(By.id("multi-select"));
        
		//create a Select object
		Select sel = new Select(multiSelect);
		
		
		//check if the dropdown allows multiple selection
		
		boolean isMlp = sel.isMultiple();
		System.out.println("Is this multiple select? " + isMlp);
		
		if(isMlp) 
		{
			List<WebElement> options = sel.getOptions();
			
			for (WebElement we : options)
			{
				String text = we.getText();
				System.out.println("The visible text value is: " + text);
				sel.selectByVisibleText(text);
				Thread.sleep(2000);
			}
				
			sel.deselectByIndex(0);
			Thread.sleep(2000);
			
			sel.deselectAll();
			Thread.sleep(2000);
			
		}
		
		tearDown();
	}

}