package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

//Facebook dropdown verification
//Open chrome browser
//Go to https://www.facebook.com/r.php
//Verify:
//month dd has 12 month options
//day dd has 31 day options
//year dd has 118 year options
//Select your date of birth	
//Quit browser

public class TaskSabah extends BaseClass {


	public static void main(String[] args) throws InterruptedException {

		setUp();
		
		//1st way:
		//create a WebElement for each
		//create a Select for each
		//call the options for each of them
		
		
		
		//2nd way:
		Select sMonth = new Select(driver.findElement(By.id("month")));
		Select sDay = new Select(driver.findElement(By.id("day")));
		Select sYear = new Select(driver.findElement(By.id("year")));
		
		System.out.println("The number of options for year is: " + sYear.getOptions().size());
		System.out.println("The numebr of options for month is: " + sMonth.getOptions().size());
		System.out.println("The number of options for days is: " + sDay.getOptions().size());
		
		
		//let us select our birthday
		sYear.selectByVisibleText("1993");
		sMonth.selectByValue("10");
		sDay.selectByIndex(27);
		
		Thread.sleep(3000);
		
		tearDown();
		
	}
}