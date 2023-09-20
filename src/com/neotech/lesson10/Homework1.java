package com.neotech.lesson10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Homework1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		/*
		 * ================== Lesson 09 HW 1 ======================= 
		 * TC: Update Customer Information
		 * 
		 * 1) Open chrome browser 
		 * 2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
		 * 3) Login to the application 
		 * 4) Verify customer "Susan McLaren" is present in the table 
		 * 5) Click on customer details 
		 * 6) Update customers last name and credit card info 
		 * 7) Verify updated customers name and credit card number is displayed in table 
		 * 8) Close browser
		 */

		setUp();
		
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		//Verify customer "Susan McLaren"
		
		
		//1st way: locate the table, get the text and check if it contains Susan
		
		//2nd way: Since I need to click on this records details, I will get all the rows
			//not just the table
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		int rowIndex = -1;
		
		for (int i = 1; i < rows.size();i++)
		{
			String rowText = rows.get(i).getText();
			rowIndex = i + 1;
			
			if(rowText.contains("Susan McLaren"))
			{
				System.out.println("Susan found!!!");
				
				
				//click on order details
				
				
				//what is the path to the order details button:
				//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[?????]/td[13]
				//the only thing I dont know is the record number where Susan will be
				
				System.out.println("Finding element i ----> " + i);
				String path = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+rowIndex+"]/td[13]";
				
				driver.findElement(By.xpath(path)).click();
				break;
			}
			
		}
		Thread.sleep(5000);
		
		
		//update customer info
		WebElement cName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		
		String textInside = cName.getAttribute("value");
		System.out.println("Current Name: " + textInside);
		
		cName.clear();
		cName.sendKeys("Susan Doe");
		
		
		//update card info
		WebElement card = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
		
		card.clear();
		card.sendKeys("43656354756746584764");
		
		//update
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		
		
		Thread.sleep(3000);
		
		
		//verify that the name changed
		String newName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']"
				+ "/tbody/tr["+rowIndex+"]/td[2]")).getText();
		
		//how do I build this xpath??
			//the name will be in the exact same row number where susan was located (rowIndex), but the info is in the columns with index 2
		System.out.println("newName ---> " + newName);
		
		
		tearDown();
		
	}

}