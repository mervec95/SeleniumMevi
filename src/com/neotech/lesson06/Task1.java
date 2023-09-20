package com.neotech.lesson06;
//Facebook dropdown verification
//Open chrome browser
//Go to https://www.facebook.com/r.php
//Verify:
//month dd has 12 month options
//day dd has 31 day options
//year dd has 118 year options
//Select your date of birth	
//Quit browser

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class Task1 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		setUp();


		WebElement month = driver.findElement(By.id("month"));
		Select monthS = new Select(month);
		monthS.selectByIndex(0);
		
		WebElement day = driver.findElement(By.id("day"));
		Select dayS = new Select(day);
		dayS.selectByValue("23");
		
		WebElement year = driver.findElement(By.id("year"));
		Select yearS = new Select(year);
		yearS.selectByValue("1995");
		
		Thread.sleep(1000);
		
		
		List<WebElement> month1 = monthS.getOptions();
		System.out.println(month1.size());
		List<WebElement> day1 = dayS.getOptions();
		System.out.println(day1.size());
		List<WebElement> year1 = yearS.getOptions();
		System.out.println(year1.size());
		
		
		//tearDown();
		

	}

}
