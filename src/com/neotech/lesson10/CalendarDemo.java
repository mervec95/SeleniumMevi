package com.neotech.lesson10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class CalendarDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// https://www.delta.com/
		
		
		setUp();
		
		//click on the calendar
		driver.findElement(By.xpath("//span[@class='calDepartLabelCont']/span[2]")).click();
		
		
		//locate the month
		String month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		
		while(!month.equals("April"))//loop until we see the month we want (April)
		{
			//click next month
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			//check again for the month: 
			month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
			
		}
		
		
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='dl-datepicker-calendar']/tbody/tr/td"));
		
		//iterate and find the day you want
		for (WebElement day : days)
		{
			String dayNum = day.getText();
			
			if(dayNum.equals("16"))
			{
				day.click();
				break;
			}
			
		}
		
		
		//return month
		//exactly same as for the depart month - we want to allow to select departure and 
		//return within the same month
		
		String returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();

		while(!returnMonth.equals("June"))
		{
			//click next month
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			//check again for the month: 
			returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		}
		
		
		//at the end of this loop, it will be June
		//select 5th of june as a return date
		
		List<WebElement> returnDays = driver.findElements(By.xpath("//table[@class='dl-datepicker-calendar']/tbody/tr/td"));

		for (WebElement day : returnDays)
		{
			String dayNum = day.getText();
			
			if(dayNum.equals("5"))
			{
				day.click();
				break;
			}
		}
		
		//click on the done button
		driver.findElement(By.xpath("//button[@value='done']")).click();
		
		Thread.sleep(3000);
		
		tearDown();
		
		

		
	}

}