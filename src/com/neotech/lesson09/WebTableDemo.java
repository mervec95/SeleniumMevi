package com.neotech.lesson09;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class WebTableDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {


		setUp();
		
		System.out.println("-------------TABLE HEADER--------------");
		
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