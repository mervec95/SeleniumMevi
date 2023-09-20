package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class DynamicTable extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		//https://hrm.neotechacademy.com/

		
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		//login 
		//get the username in cofiguration file and send it to the username box
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
				
		//log in
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
				
		//navigate to PIM menu
		driver.findElement(By.id("menu_pim_viewPimModule")).click();		
		//click on Employee List
		driver.findElement(By.linkText("Employee List")).click();
		
		
		Thread.sleep(3000);
		
		//find all the rows that contain Linda
		
		String expected = "Linda";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
		
		
		for (int i = 0; i < rows.size(); i++)//loop through all rows
		{
			String rowText = rows.get(i).getText();
			System.out.println("Row text: " + rowText);
			
			
			//if row contains Linda, I want to click on that row
			if (rowText.contains(expected))
			{
				//if the whole record is clickable:
			//	rows.get(i).click();
				
				
				
				
				//1st way:
				//if this condition is true, then Linda is found in row[i]
				//get all the 2nd column values for all rows
				//the column I want to click on, is element with index i 
			//	driver.findElements(By.xpath("//table[@id='employeeListTable']//td[2]")).get(i).click();
				
				
				//2nd way: 
				//we can save the whole column list, and then get the specific element to click on
				List<WebElement> firstColumns = driver.findElements(By.xpath("//table[@id='employeeListTable']//td[1]"));
				firstColumns.get(i).click();
				
				//print which record we click on
				
				System.out.println("Clicked on record: " + i);
				
				break;
			}
			
			
			
			Thread.sleep(5000);
			
		}
		
		
		
		
		
		tearDown();
		
		
	}

}