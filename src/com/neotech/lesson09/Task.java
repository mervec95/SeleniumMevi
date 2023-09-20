package com.neotech.lesson09;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
//benim yaptigim

//Open chrome browser
//Go to "https://www.techlistic.com/p/demo-selenium-practice.html"
//Verify table contains "Financial Center".
//Print name of all column headers
//Print data of all rows
//Quit Browser
public class Task extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		

	//	https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html

		setUp();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)");
		
		WebElement we = driver.findElement(By.xpath("//span[normalize-space()='Financial Center']"));
		we.getText();
		if(we.getText().equalsIgnoreCase("Financial Center")) {
			System.out.println("Test is pass!");
		}else {
			System.out.println("Test is fail!");
		}
		
		
List<WebElement> headerData = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		
		Iterator<WebElement> it = headerData.iterator();
		
		while(it.hasNext())
		{
			String headerText = it.next().getText();
			System.out.print(headerText + " | ");
		}
		System.out.println();
		
		
		//we can get the number of rows on web table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("The number of rows on the table is: " + rows.size());
		
		System.out.println("-------------TABLE DATA--------------");

		
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td"));
		
		for (WebElement data : rowData)
		{
			System.out.println(data.getText());
		}
		
		
		tearDown();
		
	}

}
